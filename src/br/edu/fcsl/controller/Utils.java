package br.edu.fcsl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.edu.fcsl.entidade.Subrede;

public class Utils {

	private String ping;

	public Utils() {
		super();
	}

	public Utils(String ping) {
		super();
		this.ping = ping;
	}

	public String getPing() {
		return ping;
	}

	public void setPing(String ping) {
		this.ping = ping;
	}

	public InputStream verificaComunicacao(String ip) throws UnknownHostException,
														IOException {
		InputStream is = null;

		String so = System.getProperty("os.name");
		System.out.println(" # Sistema Operacional: " + so);

		if (so.equals("Linux")) {
			is = Runtime.getRuntime().exec("ping " + ip + " -c 6")
					.getInputStream();
		} else {
			is = Runtime.getRuntime().exec("ping " + ip + " -n 3")
					.getInputStream();
		}

		return is;

	}

	public String calcularSubrede(String ip_old, String mask, int numSubredes) {
		Subrede sr = new Subrede();
		String subrede = null;
		String faixaIpInicial = sr.getFaixaIpInicial();
		String faixaIpFinal = sr.getFaixaIpFinal();
		String ipSubrede = sr.getIpSubrede();
		String ipBroadcast = sr.getIpBroadcast();
		String ipInicialUtil = sr.getIpInicialUtil();
		String ipFinalUtil = sr.getIpFinalUtil();

		int ip = Integer.parseInt(ip_old.replace(".", ""));
		System.out.print("Ip: " + ip_old + "\nNumero binario: ");
		System.out.print(numeroBinario(ip));

		String res = "#" + subrede + "|" + faixaIpInicial + "|" + faixaIpFinal
				+ ipSubrede + "|" + ipBroadcast + "|" + ipInicialUtil + "|"
				+ ipFinalUtil + "\n";

		return res;

	}

	public Object numeroBinario(int numero) {
		int numRestante;

		if (numero <= 1) {
			System.out.print(numero);
			return null;
		}

		numRestante = numero % 2;
		numeroBinario(numero >> 1);
		System.out.print(numRestante);

		{
			return " ";
		}
	}

}
