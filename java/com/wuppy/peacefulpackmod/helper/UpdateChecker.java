package com.wuppy.peacefulpackmod.helper;

import com.wuppy.peacefulpackmod.PeacefulPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker
{
	public static void checkForUpdates()
	{
		try
		{
			int currentVersion = PeacefulPack.VERSION;
			int nextVersion = getNewest();

			if (currentVersion < nextVersion)
			{
				PeacefulPack.updates = getUpdate(nextVersion);
				PeacefulPack.outdated = true;
			} else
			{
				PeacefulPack.outdated = false;
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static int getNewest() throws IOException
	{
		URL url = new URL("http://wuppy29.com/minecraft/mods/pp/newest.txt");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Language", "en-US");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);

		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuilder response = new StringBuilder();

		while ((line = br.readLine()) != null)
		{
			response.append(line);

		}
		br.close();

		return Integer.parseInt(response.toString());
	}

	private static String getUpdate(int version) throws IOException
	{
		URL url = new URL("http://wuppy29.com/minecraft/mods/pp/" + version + ".txt");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Language", "en-US");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

		connection.setUseCaches(false);
		connection.setDoInput(true);
		connection.setDoOutput(true);

		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuilder response = new StringBuilder();

		while ((line = br.readLine()) != null)
		{
			response.append(line);

		}
		br.close();

		return response.toString();
	}
}