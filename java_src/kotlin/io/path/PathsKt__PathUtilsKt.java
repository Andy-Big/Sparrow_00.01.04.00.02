package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.slf4j.Marker;
/* compiled from: PathUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00012\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0014\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u0015\u001a>\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010\u001b\u001a6\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010\u001c\u001aJ\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010\u001f\u001aB\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010 \u001a\u001c\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00022\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0001\u001a.\u0010%\u001a\u00020\u0002*\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0\u0014\"\u00020(H\u0087\b¢\u0006\u0002\u0010)\u001a\u001f\u0010%\u001a\u00020\u0002*\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020+H\u0087\b\u001a.\u0010,\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010-\u001a.\u0010.\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010-\u001a.\u0010/\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u0010-\u001a\u0015\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010&\u001a\u00020\u0002H\u0087\b\u001a6\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u001a\u0010\u0019\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0014\"\u0006\u0012\u0002\b\u00030\u001aH\u0087\b¢\u0006\u0002\u00102\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020+*\u00020\u0002H\u0087\b\u001a\u0015\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\n\u001a\u0015\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u0001H\u0087\n\u001a&\u00108\u001a\u00020+*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010:\u001a2\u0010;\u001a\u0002H<\"\n\b\u0000\u0010<\u0018\u0001*\u00020=*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010>\u001a4\u0010?\u001a\u0004\u0018\u0001H<\"\n\b\u0000\u0010<\u0018\u0001*\u00020=*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010>\u001a\r\u0010@\u001a\u00020A*\u00020\u0002H\u0087\b\u001a\r\u0010B\u001a\u00020C*\u00020\u0002H\u0087\b\u001a.\u0010D\u001a\u000204*\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u00012\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002040GH\u0087\bø\u0001\u0000\u001a0\u0010H\u001a\u0004\u0018\u00010I*\u00020\u00022\u0006\u0010J\u001a\u00020\u00012\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010K\u001a&\u0010L\u001a\u00020M*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010N\u001a(\u0010O\u001a\u0004\u0018\u00010P*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010Q\u001a,\u0010R\u001a\b\u0012\u0004\u0012\u00020T0S*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010U\u001a&\u0010V\u001a\u00020+*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010:\u001a\r\u0010W\u001a\u00020+*\u00020\u0002H\u0087\b\u001a\r\u0010X\u001a\u00020+*\u00020\u0002H\u0087\b\u001a\r\u0010Y\u001a\u00020+*\u00020\u0002H\u0087\b\u001a&\u0010Z\u001a\u00020+*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010:\u001a\u0015\u0010[\u001a\u00020+*\u00020\u00022\u0006\u00107\u001a\u00020\u0002H\u0087\b\u001a\r\u0010\\\u001a\u00020+*\u00020\u0002H\u0087\b\u001a\r\u0010]\u001a\u00020+*\u00020\u0002H\u0087\b\u001a\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00020_*\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u0001H\u0007\u001a.\u0010`\u001a\u00020\u0002*\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0\u0014\"\u00020(H\u0087\b¢\u0006\u0002\u0010)\u001a\u001f\u0010`\u001a\u00020\u0002*\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020+H\u0087\b\u001a&\u0010a\u001a\u00020+*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010:\u001a2\u0010b\u001a\u0002Hc\"\n\b\u0000\u0010c\u0018\u0001*\u00020d*\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010e\u001a<\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010I0f*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00012\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010g\u001a\r\u0010h\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010i\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0007\u001a\u0016\u0010j\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0007\u001a\u0014\u0010k\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0007\u001a8\u0010l\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00012\b\u0010m\u001a\u0004\u0018\u00010I2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u0002090\u0014\"\u000209H\u0087\b¢\u0006\u0002\u0010n\u001a\u0015\u0010o\u001a\u00020\u0002*\u00020\u00022\u0006\u0010m\u001a\u00020MH\u0087\b\u001a\u0015\u0010p\u001a\u00020\u0002*\u00020\u00022\u0006\u0010m\u001a\u00020PH\u0087\b\u001a\u001b\u0010q\u001a\u00020\u0002*\u00020\u00022\f\u0010m\u001a\b\u0012\u0004\u0012\u00020T0SH\u0087\b\u001a\r\u0010r\u001a\u00020\u0002*\u00020sH\u0087\b\u001a?\u0010t\u001a\u0002Hu\"\u0004\b\u0000\u0010u*\u00020\u00022\b\b\u0002\u0010E\u001a\u00020\u00012\u0018\u0010v\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020w\u0012\u0004\u0012\u0002Hu0GH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010x\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006y"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", IMAPStore.ID_NAME, "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "Lkotlin/Function1;", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes2.dex */
class PathsKt__PathUtilsKt extends PathsKt__PathReadWriteKt {
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    public static final String getName(Path name) {
        Intrinsics.checkNotNullParameter(name, "$this$name");
        Path fileName = name.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj != null ? obj : "";
    }

    public static final String getNameWithoutExtension(Path nameWithoutExtension) {
        String obj;
        String substringBeforeLast$default;
        Intrinsics.checkNotNullParameter(nameWithoutExtension, "$this$nameWithoutExtension");
        Path fileName = nameWithoutExtension.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringBeforeLast$default = StringsKt.substringBeforeLast$default(obj, ".", (String) null, 2, (Object) null)) == null) ? "" : substringBeforeLast$default;
    }

    public static final String getExtension(Path extension) {
        String obj;
        String substringAfterLast;
        Intrinsics.checkNotNullParameter(extension, "$this$extension");
        Path fileName = extension.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringAfterLast = StringsKt.substringAfterLast(obj, '.', "")) == null) ? "" : substringAfterLast;
    }

    public static final String getInvariantSeparatorsPath(Path invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter(invariantSeparatorsPath, "$this$invariantSeparatorsPath");
        FileSystem fileSystem = invariantSeparatorsPath.getFileSystem();
        Intrinsics.checkNotNullExpressionValue(fileSystem, "fileSystem");
        String separator = fileSystem.getSeparator();
        if (!Intrinsics.areEqual(separator, "/")) {
            String obj = invariantSeparatorsPath.toString();
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            return StringsKt.replace$default(obj, separator, "/", false, 4, (Object) null);
        }
        return invariantSeparatorsPath.toString();
    }

    public static final Path relativeTo(Path relativeTo, Path base) {
        Intrinsics.checkNotNullParameter(relativeTo, "$this$relativeTo");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(relativeTo, base);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            throw new IllegalArgumentException(Intrinsics.stringPlus(message, "\nthis path: " + relativeTo + "\nbase path: " + base), e);
        }
    }

    public static final Path relativeToOrSelf(Path relativeToOrSelf, Path base) {
        Intrinsics.checkNotNullParameter(relativeToOrSelf, "$this$relativeToOrSelf");
        Intrinsics.checkNotNullParameter(base, "base");
        Path relativeToOrNull = PathsKt.relativeToOrNull(relativeToOrSelf, base);
        return relativeToOrNull != null ? relativeToOrNull : relativeToOrSelf;
    }

    public static final Path relativeToOrNull(Path relativeToOrNull, Path base) {
        Intrinsics.checkNotNullParameter(relativeToOrNull, "$this$relativeToOrNull");
        Intrinsics.checkNotNullParameter(base, "base");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(relativeToOrNull, base);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static final Path copyTo(Path path, Path path2, boolean z) {
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    static /* synthetic */ Path copyTo$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    private static final Path copyTo(Path path, Path path2, CopyOption... copyOptionArr) {
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "Files.copy(this, target, *options)");
        return copy;
    }

    private static final boolean exists(Path path, LinkOption... linkOptionArr) {
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean notExists(Path path, LinkOption... linkOptionArr) {
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isRegularFile(Path path, LinkOption... linkOptionArr) {
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isDirectory(Path path, LinkOption... linkOptionArr) {
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isSymbolicLink(Path path) {
        return Files.isSymbolicLink(path);
    }

    private static final boolean isExecutable(Path path) {
        return Files.isExecutable(path);
    }

    private static final boolean isHidden(Path path) {
        return Files.isHidden(path);
    }

    private static final boolean isReadable(Path path) {
        return Files.isReadable(path);
    }

    private static final boolean isWritable(Path path) {
        return Files.isWritable(path);
    }

    private static final boolean isSameFileAs(Path path, Path path2) {
        return Files.isSameFile(path, path2);
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Marker.ANY_MARKER;
        }
        return PathsKt.listDirectoryEntries(path, str);
    }

    public static final List<Path> listDirectoryEntries(Path listDirectoryEntries, String glob) {
        Intrinsics.checkNotNullParameter(listDirectoryEntries, "$this$listDirectoryEntries");
        Intrinsics.checkNotNullParameter(glob, "glob");
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(listDirectoryEntries, glob);
        Throwable th = null;
        try {
            DirectoryStream<Path> it = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            List<Path> list = CollectionsKt.toList(it);
            CloseableKt.closeFinally(newDirectoryStream, th);
            return list;
        } finally {
        }
    }

    private static final <T> T useDirectoryEntries(Path path, String str, Function1<? super Sequence<? extends Path>, ? extends T> function1) {
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        Throwable th = null;
        try {
            DirectoryStream<Path> it = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            T invoke = function1.invoke(CollectionsKt.asSequence(it));
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(newDirectoryStream, th);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(newDirectoryStream, th2);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    static /* synthetic */ Object useDirectoryEntries$default(Path path, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Marker.ANY_MARKER;
        }
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        Throwable th = null;
        try {
            DirectoryStream<Path> it = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object invoke = function1.invoke(CollectionsKt.asSequence(it));
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(newDirectoryStream, th);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(newDirectoryStream, th2);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    private static final void forEachDirectoryEntry(Path path, String str, Function1<? super Path, Unit> function1) {
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        Throwable th = null;
        try {
            DirectoryStream<Path> it = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            for (Path path2 : it) {
                function1.invoke(path2);
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(newDirectoryStream, th);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(newDirectoryStream, th2);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    static /* synthetic */ void forEachDirectoryEntry$default(Path path, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = Marker.ANY_MARKER;
        }
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        Throwable th = null;
        try {
            DirectoryStream<Path> it = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            for (Path path2 : it) {
                function1.invoke(path2);
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(newDirectoryStream, th);
            } else if (newDirectoryStream != null) {
                newDirectoryStream.close();
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(newDirectoryStream, th2);
                } else if (newDirectoryStream != null) {
                    try {
                        newDirectoryStream.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    private static final long fileSize(Path path) {
        return Files.size(path);
    }

    private static final void deleteExisting(Path path) {
        Files.delete(path);
    }

    private static final boolean deleteIfExists(Path path) {
        return Files.deleteIfExists(path);
    }

    private static final Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) {
        Path createDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createDirectory, "Files.createDirectory(this, *attributes)");
        return createDirectory;
    }

    private static final Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) {
        Path createDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createDirectories, "Files.createDirectories(this, *attributes)");
        return createDirectories;
    }

    private static final Path moveTo(Path path, Path path2, CopyOption... copyOptionArr) {
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(move, "Files.move(this, target, *options)");
        return move;
    }

    private static final Path moveTo(Path path, Path path2, boolean z) {
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(move, "Files.move(this, target, *options)");
        return move;
    }

    static /* synthetic */ Path moveTo$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(move, "Files.move(this, target, *options)");
        return move;
    }

    private static final FileStore fileStore(Path path) {
        FileStore fileStore = Files.getFileStore(path);
        Intrinsics.checkNotNullExpressionValue(fileStore, "Files.getFileStore(this)");
        return fileStore;
    }

    private static final Object getAttribute(Path path, String str, LinkOption... linkOptionArr) {
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) {
        Path attribute = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(attribute, "Files.setAttribute(this,…tribute, value, *options)");
        return attribute;
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... linkOptionArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... linkOptionArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v != null) {
            return v;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        PathsKt.fileAttributeViewNotAvailable(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> attributeViewClass) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(attributeViewClass, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + attributeViewClass + " is not available for the file " + path + '.');
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... linkOptionArr) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        A a = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a, "Files.readAttributes(thi… A::class.java, *options)");
        return a;
    }

    private static final Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) {
        Map<String, Object> readAttributes = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(readAttributes, "Files.readAttributes(this, attributes, *options)");
        return readAttributes;
    }

    private static final FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) {
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "Files.getLastModifiedTime(this, *options)");
        return lastModifiedTime;
    }

    private static final Path setLastModifiedTime(Path path, FileTime fileTime) {
        Path lastModifiedTime = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "Files.setLastModifiedTime(this, value)");
        return lastModifiedTime;
    }

    private static final UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) {
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final Path setOwner(Path path, UserPrincipal userPrincipal) {
        Path owner = Files.setOwner(path, userPrincipal);
        Intrinsics.checkNotNullExpressionValue(owner, "Files.setOwner(this, value)");
        return owner;
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) {
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "Files.getPosixFilePermissions(this, *options)");
        return posixFilePermissions;
    }

    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> set) {
        Path posixFilePermissions = Files.setPosixFilePermissions(path, set);
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "Files.setPosixFilePermissions(this, value)");
        return posixFilePermissions;
    }

    private static final Path createLinkPointingTo(Path path, Path path2) {
        Path createLink = Files.createLink(path, path2);
        Intrinsics.checkNotNullExpressionValue(createLink, "Files.createLink(this, target)");
        return createLink;
    }

    private static final Path createSymbolicLinkPointingTo(Path path, Path path2, FileAttribute<?>... fileAttributeArr) {
        Path createSymbolicLink = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createSymbolicLink, "Files.createSymbolicLink…his, target, *attributes)");
        return createSymbolicLink;
    }

    private static final Path readSymbolicLink(Path path) {
        Path readSymbolicLink = Files.readSymbolicLink(path);
        Intrinsics.checkNotNullExpressionValue(readSymbolicLink, "Files.readSymbolicLink(this)");
        return readSymbolicLink;
    }

    private static final Path createFile(Path path, FileAttribute<?>... fileAttributeArr) {
        Path createFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createFile, "Files.createFile(this, *attributes)");
        return createFile;
    }

    static /* synthetic */ Path createTempFile$default(String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    private static final Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) {
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "Files.createTempFile(prefix, suffix, *attributes)");
        return createTempFile;
    }

    static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "Files.createTempFile(dir…fix, suffix, *attributes)");
        return createTempFile;
    }

    private static final Path createTempFile(Path path, String str, String str2, FileAttribute<?>... fileAttributeArr) {
        Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "Files.createTempFile(dir…fix, suffix, *attributes)");
        return createTempFile;
    }

    static /* synthetic */ Path createTempDirectory$default(String str, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    private static final Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) {
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory, "Files.createTempDirectory(prefix, *attributes)");
        return createTempDirectory;
    }

    static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory, "Files.createTempDirector…ory, prefix, *attributes)");
        return createTempDirectory;
    }

    private static final Path createTempDirectory(Path path, String str, FileAttribute<?>... fileAttributeArr) {
        Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory, "Files.createTempDirector…ory, prefix, *attributes)");
        return createTempDirectory;
    }

    private static final Path div(Path div, Path path) {
        Intrinsics.checkNotNullParameter(div, "$this$div");
        Path resolve = div.resolve(path);
        Intrinsics.checkNotNullExpressionValue(resolve, "this.resolve(other)");
        return resolve;
    }

    private static final Path div(Path div, String str) {
        Intrinsics.checkNotNullParameter(div, "$this$div");
        Path resolve = div.resolve(str);
        Intrinsics.checkNotNullExpressionValue(resolve, "this.resolve(other)");
        return resolve;
    }

    private static final Path Path(String str) {
        Path path = Paths.get(str, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "Paths.get(path)");
        return path;
    }

    private static final Path Path(String str, String... strArr) {
        Path path = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(path, "Paths.get(base, *subpaths)");
        return path;
    }

    private static final Path toPath(URI uri) {
        Path path = Paths.get(uri);
        Intrinsics.checkNotNullExpressionValue(path, "Paths.get(this)");
        return path;
    }
}
