package br.edu.fcsl.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subrede {
	@Id
	@GeneratedValue
	private Long id;
	private String faixaIpInicial;
	private String faixaIpFinal;
	private String ipSubrede;
	private String ipBroadcast;
	private String ipInicialUtil;
	private String ipFinalUtil;

	public Subrede() {
		super();
	}

	public Subrede(Long id, String faixaIpInicial, String faixaIpFinal,
			String ipSubrede, String ipBroadcast, String ipInicialUtil,
			String ipFinalUtil) {
		super();
		this.id = id;
		this.faixaIpInicial = faixaIpInicial;
		this.faixaIpFinal = faixaIpFinal;
		this.ipSubrede = ipSubrede;
		this.ipBroadcast = ipBroadcast;
		this.ipInicialUtil = ipInicialUtil;
		this.ipFinalUtil = ipFinalUtil;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	public void setId(final Long id) {
		this.id = id;
	}

	public String getFaixaIpInicial() {
		return faixaIpInicial;
	}

	public void setFaixaIpInicial(String faixaIpInicial) {
		this.faixaIpInicial = faixaIpInicial;
	}

	public String getFaixaIpFinal() {
		return faixaIpFinal;
	}

	public void setFaixaIpFinal(String faixaIpFinal) {
		this.faixaIpFinal = faixaIpFinal;
	}

	public String getIpSubrede() {
		return ipSubrede;
	}

	public void setIpSubrede(String ipSubrede) {
		this.ipSubrede = ipSubrede;
	}

	public String getIpBroadcast() {
		return ipBroadcast;
	}

	public void setIpBroadcast(String ipBroadcast) {
		this.ipBroadcast = ipBroadcast;
	}

	public String getIpInicialUtil() {
		return ipInicialUtil;
	}

	public void setIpInicialUtil(String ipInicialUtil) {
		this.ipInicialUtil = ipInicialUtil;
	}

	public String getIpFinalUtil() {
		return ipFinalUtil;
	}

	public void setIpFinalUtil(String ipFinalUtil) {
		this.ipFinalUtil = ipFinalUtil;
	}

}
