package com.rigol.iguardservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.rigol.iguardservice.IGuardListener;
/* loaded from: classes.dex */
public interface IGuardService extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IGuardService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void checkNewVersion(String str) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void heartbeat() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void saveLog(String str) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setListener(IGuardListener iGuardListener) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setLocked(boolean z) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setMotorForward() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setMotorManualReset() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setMotorPos(int i, boolean z) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setMotorRecovery() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setMotorReverse() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setPackageName(String str) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardService
        public void setSystemPowerOff() throws RemoteException {
        }
    }

    void checkNewVersion(String str) throws RemoteException;

    void heartbeat() throws RemoteException;

    void saveLog(String str) throws RemoteException;

    void setListener(IGuardListener iGuardListener) throws RemoteException;

    void setLocked(boolean z) throws RemoteException;

    void setMotorForward() throws RemoteException;

    void setMotorManualReset() throws RemoteException;

    void setMotorPos(int i, boolean z) throws RemoteException;

    void setMotorRecovery() throws RemoteException;

    void setMotorReverse() throws RemoteException;

    void setPackageName(String str) throws RemoteException;

    void setSystemPowerOff() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGuardService {
        private static final String DESCRIPTOR = "com.rigol.iguardservice.IGuardService";
        static final int TRANSACTION_checkNewVersion = 5;
        static final int TRANSACTION_heartbeat = 3;
        static final int TRANSACTION_saveLog = 2;
        static final int TRANSACTION_setListener = 1;
        static final int TRANSACTION_setLocked = 6;
        static final int TRANSACTION_setMotorForward = 9;
        static final int TRANSACTION_setMotorManualReset = 12;
        static final int TRANSACTION_setMotorPos = 7;
        static final int TRANSACTION_setMotorRecovery = 10;
        static final int TRANSACTION_setMotorReverse = 8;
        static final int TRANSACTION_setPackageName = 4;
        static final int TRANSACTION_setSystemPowerOff = 11;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGuardService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGuardService)) {
                return (IGuardService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    setListener(IGuardListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    saveLog(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    heartbeat();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPackageName(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    checkNewVersion(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLocked(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMotorPos(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMotorReverse();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMotorForward();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMotorRecovery();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSystemPowerOff();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMotorManualReset();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IGuardService {
            public static IGuardService sDefaultImpl;
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

            @Override // com.rigol.iguardservice.IGuardService
            public void setListener(IGuardListener iGuardListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iGuardListener != null ? iGuardListener.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setListener(iGuardListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void saveLog(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().saveLog(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void heartbeat() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().heartbeat();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setPackageName(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPackageName(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void checkNewVersion(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().checkNewVersion(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setLocked(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLocked(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setMotorPos(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMotorPos(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setMotorReverse() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMotorReverse();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setMotorForward() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMotorForward();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setMotorRecovery() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMotorRecovery();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setSystemPowerOff() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSystemPowerOff();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardService
            public void setMotorManualReset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMotorManualReset();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGuardService iGuardService) {
            if (Proxy.sDefaultImpl != null || iGuardService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGuardService;
            return true;
        }

        public static IGuardService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
