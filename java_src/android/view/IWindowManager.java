package android.view;

import android.graphics.Point;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.IRotationWatcher;
/* loaded from: classes.dex */
public interface IWindowManager extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IWindowManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IWindowManager
        public void getBaseDisplaySize(int i, Point point) throws RemoteException {
        }

        @Override // android.view.IWindowManager
        public void getInitialDisplaySize(int i, Point point) throws RemoteException {
        }

        @Override // android.view.IWindowManager
        public void getRealDisplaySize(Point point) throws RemoteException {
        }

        @Override // android.view.IWindowManager
        public int getRotation() throws RemoteException {
            return 0;
        }

        @Override // android.view.IWindowManager
        public void removeRotationWatcher(IRotationWatcher iRotationWatcher) throws RemoteException {
        }
    }

    void getBaseDisplaySize(int i, Point point) throws RemoteException;

    void getInitialDisplaySize(int i, Point point) throws RemoteException;

    void getRealDisplaySize(Point point) throws RemoteException;

    int getRotation() throws RemoteException;

    void removeRotationWatcher(IRotationWatcher iRotationWatcher) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IWindowManager {
        private static final String DESCRIPTOR = "android.view.IWindowManager";
        static final int TRANSACTION_getBaseDisplaySize = 2;
        static final int TRANSACTION_getInitialDisplaySize = 1;
        static final int TRANSACTION_getRealDisplaySize = 3;
        static final int TRANSACTION_getRotation = 4;
        static final int TRANSACTION_removeRotationWatcher = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWindowManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWindowManager)) {
                return (IWindowManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int readInt = parcel.readInt();
                Point point = new Point();
                getInitialDisplaySize(readInt, point);
                parcel2.writeNoException();
                parcel2.writeInt(1);
                point.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                int readInt2 = parcel.readInt();
                Point point2 = new Point();
                getBaseDisplaySize(readInt2, point2);
                parcel2.writeNoException();
                parcel2.writeInt(1);
                point2.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                Point point3 = new Point();
                getRealDisplaySize(point3);
                parcel2.writeNoException();
                parcel2.writeInt(1);
                point3.writeToParcel(parcel2, 1);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                int rotation = getRotation();
                parcel2.writeNoException();
                parcel2.writeInt(rotation);
                return true;
            } else if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                removeRotationWatcher(IRotationWatcher.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IWindowManager {
            public static IWindowManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.view.IWindowManager
            public void getInitialDisplaySize(int i, Point point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getInitialDisplaySize(i, point);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        point.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.view.IWindowManager
            public void getBaseDisplaySize(int i, Point point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getBaseDisplaySize(i, point);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        point.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.view.IWindowManager
            public void getRealDisplaySize(Point point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getRealDisplaySize(point);
                        return;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        point.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.view.IWindowManager
            public int getRotation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRotation();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.view.IWindowManager
            public void removeRotationWatcher(IRotationWatcher iRotationWatcher) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRotationWatcher != null ? iRotationWatcher.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeRotationWatcher(iRotationWatcher);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IWindowManager iWindowManager) {
            if (Proxy.sDefaultImpl != null || iWindowManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iWindowManager;
            return true;
        }

        public static IWindowManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
