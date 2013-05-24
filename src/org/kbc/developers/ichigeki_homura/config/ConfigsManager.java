package org.kbc.developers.ichigeki_homura.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ConfigsManager {
	  private Serializer serializer = new Persister();
	  private File file;

	  /**
	   * @param file 読み込み・書き出し用ファイル
	   * */
	  public ConfigsManager(String path){

		  file = new File(path);

	  }

	  /**
	   * ConfigオブジェクトをXML保存する
	   * */
	  public void save(Configs conf) throws Exception{
		  serializer.write(conf, file);
	  }

	  /**
	   * XMLファイルからCompanyオブジェクトを読む込みます。
	   * */
	  public Configs load() throws Exception{

	    return serializer.read(Configs.class, file, true);
	  }


}

