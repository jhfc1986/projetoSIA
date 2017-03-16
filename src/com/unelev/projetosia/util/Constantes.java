package com.unelev.projetosia.util;

public final class Constantes {
	
	
	public static final String STRING_BRANCO = "";
	
	//Constantes chamados
	
	public static final String STATUS_ABERTO = "A";
	public static final String STATUS_PENDENTE = "P";
	public static final String STATUS_ENCERRADO = "E";
	public static final String CHAMADO_SUCCESS = "chamado.success";
	public static final String CHAMADO_DADOS_CLIENTE = "chamado.dadosCliente";
	public static final String CHAMADO_DADOS_PROBLEMA = "chamado.dadosProblema";
	public static final String CHAMADO_CLIENTE_NAO_ENCONTRADO = "chamado.clienteNaoEncontrado";
	public static final String CHAMADOS_NAO_ENCONTRADOS = "chamado.chamadosNaoEncontrados";
	public static final String CHAMADOS_DT_MIN = "01/01/1996";
	public static final String DATA_INICIO_INFERIOR = "chamado.dataInicialInferior";
	public static final String DATA_INICIO_SUPERIOR = "chamado.dataInicialSuperior";
	public static final String DATA_FINAL_INFERIOR = "chamado.dataFinalInferior";
	public static final String DATA_FINAL_SUPERIOR = "chamado.dataFinalSuperior";
	public static final String DATA_INICIAL_SUPERIOR_FINAL = "chamado.dataIniSuperiorFin";
	public static final String NUMERO_CNPJ_INVALIDO = "chamado.cnpjInvalido";
	
	//Constantes atendimentos
	
    public static final String CLIENTE_NAO_ENCONTRADO = "listAtendimentos.clienteNaoEncontrado";
	public static final String ATENDIMENTO_CHAMADOS_NAO_ENCONTRADOS= "listAtendimentos.chamadosNaoEncontrados";
	public static final String ATENDIMENTO_CHAMADOS_NAO_ENCONTRADOS_PERIODO = "listAtendimentos.chamadosNaoEncontradosPer";
	public static final String ATENDIMENTO_DATA_INICIO_FIM_OBRIGATORIO = "listAtendimentos.periodoAtendimento";
	public static final String ATENDIMENTO_ITEM_EXISTENTE = "atendimentos.existeItem";
	public static final String ATENDIMENTO_PENDENCIA_SUCC = "atendimentos.pendenciaSucc";
	public static final String ATENDIMENTO_ENCERRAR_SUCC = "atendimentos.encerrSucc";
	public static final String ATENDIMENTO_FICHA_ERRO = "atendimentos.fichaErr";
	public static final String ATENDIMENTO_ITENS_ERRO = "atendimentos.itemErr";
	public static final String ATENDIMENTO_HORA_ENT_ERRO = "atendimentos.horEntErr";
	public static final String ATENDIMENTO_HORA_SAI_ERRO = "atendimentos.horSaiErr";
	
	//Constantes modelo subsistema
	
    public static final Integer ID_CASA_MAQUINAS = new Integer(1);
	public static final Integer ID_CABINE = new Integer(2);
	public static final Integer ID_PAVIMENTO = new Integer(3);
	public static final Integer ID_POCO = new Integer(4);	
	public static final Integer ID_CONTRA_PESO = new Integer(5);
}
