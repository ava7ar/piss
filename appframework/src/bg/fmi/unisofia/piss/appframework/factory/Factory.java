package bg.fmi.unisofia.piss.appframework.factory;

import bg.fmi.unisofia.piss.appframework.shared.AccountManager;
import bg.fmi.unisofia.piss.appframework.shared.ReservationManager;
import bg.fmi.unisofia.piss.appframework.shared.impl.AccountManagerImpl;
import bg.fmi.unisofia.piss.appframework.shared.impl.ReservationManagerImpl;

public final class Factory {

	private static Factory mFactory;
	
	private Factory() {
		
	}
	
	public static Factory getInstance() {
		if (mFactory == null) { 
			return new Factory();
		} else {
			return mFactory;
		}
	}
	
	private AccountManager getAccountManager() {
		return new AccountManagerImpl();
	}
	
	private ReservationManager getReservationManager() {
		return new ReservationManagerImpl();
	}
}
