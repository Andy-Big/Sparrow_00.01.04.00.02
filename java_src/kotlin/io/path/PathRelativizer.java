package kotlin.io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: PathUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }

    public final Path tryRelativeTo(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        Path bn = base.normalize();
        Path r = path.normalize();
        Path rn = bn.relativize(r);
        Intrinsics.checkNotNullExpressionValue(bn, "bn");
        int nameCount = bn.getNameCount();
        Intrinsics.checkNotNullExpressionValue(r, "pn");
        int min = Math.min(nameCount, r.getNameCount());
        for (int i = 0; i < min && !(!Intrinsics.areEqual(bn.getName(i), parentPath)); i++) {
            if (!Intrinsics.areEqual(r.getName(i), parentPath)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!(!Intrinsics.areEqual(r, bn)) || !Intrinsics.areEqual(bn, emptyPath)) {
            String obj = rn.toString();
            Intrinsics.checkNotNullExpressionValue(rn, "rn");
            FileSystem fileSystem = rn.getFileSystem();
            Intrinsics.checkNotNullExpressionValue(fileSystem, "rn.fileSystem");
            String separator = fileSystem.getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (StringsKt.endsWith$default(obj, separator, false, 2, (Object) null)) {
                FileSystem fileSystem2 = rn.getFileSystem();
                FileSystem fileSystem3 = rn.getFileSystem();
                Intrinsics.checkNotNullExpressionValue(fileSystem3, "rn.fileSystem");
                r = fileSystem2.getPath(StringsKt.dropLast(obj, fileSystem3.getSeparator().length()), new String[0]);
            } else {
                r = rn;
            }
        }
        Intrinsics.checkNotNullExpressionValue(r, "r");
        return r;
    }
}
