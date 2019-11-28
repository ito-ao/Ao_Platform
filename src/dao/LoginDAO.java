package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Account;
import common.Attr;
import common.EnvInfo;

public class LoginDAO {
	private EnvInfo info;
	private String dbPath;
	private String dbUserName;
	private String dbPass;
	
	public LoginDAO() {
		try {
			//共通定義ファイルのインスタンス
			this.info = new EnvInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}	
			//プロパティファイルから諸々取得
			this.dbPath = info.getPropertiesMasterPass(Attr.DB_PATH);
			this.dbUserName = info.getPropertiesMasterPass(Attr.DB_USER_NAME);
			this.dbPass = info.getPropertiesMasterPass(Attr.DB_PASSWORD);
	}
	
	//--------------------
	//ID,パスワードで検索して名前とアドレスをヒットさせる（データベース側で作らなきゃダメよ）
	//--------------------
	public Account findByLogin(String LoginId, String LoginPass) {
		Account returnAccount = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(this.dbPath + "?useUnicode=true&characterEncoding=utf8", this.dbUserName, this.dbPass);
			PreparedStatement prepared = con.prepareStatement("SELECT * FROM テーブル名 WHERE ID = ? AND pass = ?");
			prepared.setString(1, LoginId);
			prepared.setString(2, LoginPass);

			ResultSet rs = prepared.executeQuery();

			if (rs.next()) { //1ヒット想定
				String name = rs.getString("NAME");
				String mail = rs.getString("MAIL");
				
				returnAccount = new Account(name, LoginId, LoginPass, mail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnAccount;
	}
}
