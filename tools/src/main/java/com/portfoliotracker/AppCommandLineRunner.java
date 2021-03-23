package com.portfoliotracker;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portfoliotracker.ui.AssetFrame;
import com.portfoliotracker.ui.Window;

/**
 * This CommandLineRunner fires off at runtime and boots up our GUI.
 */
@Component
public class AppCommandLineRunner implements CommandLineRunner {

	private Window window;
	
	public static  Dimension dim;

	@Autowired
	public AppCommandLineRunner(Window window,AssetFrame assetFrame) {
		this.window = window;
		AppCommandLineRunner.dim = Toolkit.getDefaultToolkit().getScreenSize();

	}

	@Override
	public void run(String... args) throws Exception {
		// This boots up the GUI.
		// EventQueue.invokeLater(() -> window.setVisible(true));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
					window.setLocation(dim.width / 2 - window.getSize().width / 2,
							dim.height / 2 - window.getSize().height / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
