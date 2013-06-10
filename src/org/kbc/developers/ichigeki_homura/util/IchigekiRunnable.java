package org.kbc.developers.ichigeki_homura.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.SwingUtilities;

public class IchigekiRunnable implements Runnable {
	private final String mRomFilePath;
	private final IchigekiEventListener mCallback;
	
	public interface IchigekiEventListener {
		void onMessage(String message);
		void onFinish(Throwable e);
	}

	public IchigekiRunnable(String romFilePath, IchigekiEventListener cllback) {
		mRomFilePath = romFilePath;
		mCallback = cllback;
	}

	private class HandleMessageRunnable implements Runnable {
		private final String mMessage;
		public HandleMessageRunnable(String message) {
			mMessage = message;
		}
		@Override
		public void run() {
			mCallback.onMessage(mMessage);
		}
	}

	private class HandleFinishRunnable implements Runnable {
		private final Exception mException;
		public HandleFinishRunnable(Exception e) {
			mException = e;
		}
		@Override
		public void run() {
			mCallback.onFinish(mException);
		}
	}

	private void handleMessage(String message) {
		SwingUtilities.invokeLater(new HandleMessageRunnable(message));
	}

	private void handleFinish(Exception e) {
		SwingUtilities.invokeLater(new HandleFinishRunnable(e));
	}

	@Override
	public void run() {
		mCallback.onMessage("start");

		ZipInputStream zis;
		try {
			zis = new ZipInputStream(new FileInputStream(new File(mRomFilePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			handleMessage("file not found");
			handleFinish(e);
			return;
		}

		ZipEntry ze;
		try {
			while ((ze = zis.getNextEntry()) != null) {
				handleMessage(ze.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
			handleFinish(e);
		}

		handleFinish(null);
	}
}
