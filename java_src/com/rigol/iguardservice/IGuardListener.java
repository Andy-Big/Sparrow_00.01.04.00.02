package com.rigol.iguardservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.rigol.lib.data.Firmware;
/* loaded from: classes.dex */
public interface IGuardListener extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IGuardListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onDownload(int i) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onInstall(int i, String str) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onLocked(boolean z) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorError() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorNeedManualReset() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorPinchHand() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorPos(int i, boolean z) throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onPowerOffMotorError() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onPowerOffMotorPinch() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onUpdate(Firmware firmware) throws RemoteException {
        }
    }

    void onDownload(int i) throws RemoteException;

    void onError(int i, String str) throws RemoteException;

    void onInstall(int i, String str) throws RemoteException;

    void onLocked(boolean z) throws RemoteException;

    void onMotorError() throws RemoteException;

    void onMotorNeedManualReset() throws RemoteException;

    void onMotorPinchHand() throws RemoteException;

    void onMotorPos(int i, boolean z) throws RemoteException;

    void onPowerOffMotorError() throws RemoteException;

    void onPowerOffMotorPinch() throws RemoteException;

    void onUpdate(Firmware firmware) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGuardListener {
        private static final String DESCRIPTOR = "com.rigol.iguardservice.IGuardListener";
        static final int TRANSACTION_onDownload = 2;
        static final int TRANSACTION_onError = 4;
        static final int TRANSACTION_onInstall = 3;
        static final int TRANSACTION_onLocked = 5;
        static final int TRANSACTION_onMotorError = 8;
        static final int TRANSACTION_onMotorNeedManualReset = 9;
        static final int TRANSACTION_onMotorPinchHand = 7;
        static final int TRANSACTION_onMotorPos = 6;
        static final int TRANSACTION_onPowerOffMotorError = 11;
        static final int TRANSACTION_onPowerOffMotorPinch = 10;
        static final int TRANSACTION_onUpdate = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGuardListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGuardListener)) {
                return (IGuardListener) queryLocalInterface;
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
                    onUpdate(parcel.readInt() != 0 ? Firmware.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownload(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInstall(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onError(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onLocked(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMotorPos(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMotorPinchHand();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMotorError();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMotorNeedManualReset();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPowerOffMotorPinch();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPowerOffMotorError();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IGuardListener {
            public static IGuardListener sDefaultImpl;
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

            @Override // com.rigol.iguardservice.IGuardListener
            public void onUpdate(Firmware firmware) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (firmware != null) {
                        obtain.writeInt(1);
                        firmware.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onUpdate(firmware);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onDownload(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownload(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onInstall(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstall(i, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(i, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onLocked(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onLocked(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onMotorPos(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMotorPos(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onMotorPinchHand() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMotorPinchHand();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onMotorError() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMotorError();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onMotorNeedManualReset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMotorNeedManualReset();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onPowerOffMotorPinch() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPowerOffMotorPinch();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.rigol.iguardservice.IGuardListener
            public void onPowerOffMotorError() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPowerOffMotorError();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGuardListener iGuardListener) {
            if (Proxy.sDefaultImpl != null || iGuardListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGuardListener;
            return true;
        }

        public static IGuardListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
