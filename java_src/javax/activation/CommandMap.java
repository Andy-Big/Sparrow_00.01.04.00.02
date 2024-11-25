package javax.activation;

import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public abstract class CommandMap {
    private static CommandMap defaultCommandMap;
    private static Map<ClassLoader, CommandMap> map = new WeakHashMap();

    public abstract DataContentHandler createDataContentHandler(String str);

    public abstract CommandInfo[] getAllCommands(String str);

    public abstract CommandInfo getCommand(String str, String str2);

    public String[] getMimeTypes() {
        return null;
    }

    public abstract CommandInfo[] getPreferredCommands(String str);

    public static synchronized CommandMap getDefaultCommandMap() {
        synchronized (CommandMap.class) {
            if (defaultCommandMap != null) {
                return defaultCommandMap;
            }
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            CommandMap commandMap = map.get(contextClassLoader);
            if (commandMap == null) {
                commandMap = new MailcapCommandMap();
                map.put(contextClassLoader, commandMap);
            }
            return commandMap;
        }
    }

    public static synchronized void setDefaultCommandMap(CommandMap commandMap) {
        synchronized (CommandMap.class) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                try {
                    securityManager.checkSetFactory();
                } catch (SecurityException e) {
                    ClassLoader classLoader = CommandMap.class.getClassLoader();
                    if (classLoader == null || classLoader.getParent() == null || classLoader != commandMap.getClass().getClassLoader()) {
                        throw e;
                    }
                }
            }
            map.remove(SecuritySupport.getContextClassLoader());
            defaultCommandMap = commandMap;
        }
    }

    public CommandInfo[] getPreferredCommands(String str, DataSource dataSource) {
        return getPreferredCommands(str);
    }

    public CommandInfo[] getAllCommands(String str, DataSource dataSource) {
        return getAllCommands(str);
    }

    public CommandInfo getCommand(String str, String str2, DataSource dataSource) {
        return getCommand(str, str2);
    }

    public DataContentHandler createDataContentHandler(String str, DataSource dataSource) {
        return createDataContentHandler(str);
    }
}
