package bg.fmi.unisofia.piss.appframework.core;

public abstract class Account {

	private String mUserName;
	
	private String mUserType;
	
	private String mUserMail;
	
	public String getUserName() {
		return mUserName;
	}

	public void setUserName(String username) {
		mUserName = username;
	}

	public String getUserType() {
		return mUserType;
	}

	public void setUserType(String usertype) {
		mUserType = usertype;
	}

	public String getUserMail() {
		return mUserMail;
	}

	public void setUserMail(String usermail) {
		mUserMail = usermail;
	}

}
