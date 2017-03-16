package com.unelev.projetosia.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import com.unelev.projetosia.business.AtendimentoBusiness;
import com.unelev.projetosia.business.ClienteBusiness;
import com.unelev.projetosia.business.ClienteEquipamentoBusiness;
import com.unelev.projetosia.business.EquipamentoBusiness;
import com.unelev.projetosia.business.ItemAtendimentoBusiness;
import com.unelev.projetosia.business.ItemEquipamentoBusiness;
import com.unelev.projetosia.entity.Atendimento;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.entity.ClienteEquipamento;
import com.unelev.projetosia.entity.Equipamento;
import com.unelev.projetosia.entity.ItemAtendimento;
import com.unelev.projetosia.entity.ItemEquipamento;
import com.unelev.projetosia.util.Constantes;
import com.unelev.projetosia.util.Utils;

@ManagedBean(name = "fichaAtendimentoBean")
@SessionScoped
public class FichaAtendimentoBean extends BeanRoot {
	
	@ManagedProperty(value="#{atendimentoBean}")
	private AtendimentoBean atendimentoBean;
	
	private Atendimento atendimento;
	
	private Cliente cliente;
	
	private Equipamento equipamento;
	
	private ClienteEquipamento clienteEquipamento;
	
	private ItemAtendimento itemAtendimento;

	private ItemEquipamento itemEquipamento;

	private String horaAtendimentoEntrada;
	
	private String horaAtendimentoSaida;
	
	private String nomeItem;
	
	private List<SelectItem> marcaElevador = new ArrayList<SelectItem>();
	
    private List<SelectItem> modeloElevador = new ArrayList<SelectItem>(); 
    
    private List<ItemEquipamento> itensManutencao = new ArrayList<ItemEquipamento>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FichaAtendimentoBean(){
		 
		 atendimento = new Atendimento();
		 cliente = new Cliente();
	     equipamento = new Equipamento();
		 clienteEquipamento = new ClienteEquipamento();
		 itemEquipamento = new ItemEquipamento();
		 itemAtendimento = new ItemAtendimento();
		 nomeItem = "";
		
	 }
	
	/**
	 * 
	 * serve para submeter o form antes de exibir
	 * a pop up de itens
	 * 
	 */
	public void carregaSessao(){
		
		clienteEquipamento.setNumParadas(clienteEquipamento.getNumParadas());
		clienteEquipamento.setQtdEquip(clienteEquipamento.getQtdEquip());
		
	}
	
	/**
	 * 
	 * metodo responsavel por encerrar o atendimento
	 * aberto pelo cliente
	 * 
	 */
	public void encerrarAtendimento(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		AtendimentoBusiness atm = new AtendimentoBusiness();
		
		ClienteEquipamentoBusiness cliEq = new ClienteEquipamentoBusiness();
		
		if(itensManutencao.isEmpty()){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_ITENS_ERRO), null));
		}else if(!atm.validateHora(horaAtendimentoEntrada)){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_HORA_ENT_ERRO), null));
			
		}else if(!atm.validateHora(horaAtendimentoSaida)){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_HORA_SAI_ERRO), null));
		}else if(!cliEq.validateClienteEquipamento(clienteEquipamento)){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_FICHA_ERRO), null));
		}else if(equipamento.getMarcaEquipamento().equals("") || equipamento.getNumModelo() == 0){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_FICHA_ERRO), null));
		}else if(atm.validateFichaAtendimento(atendimento)){
		    
			//salvar equipamento
			
			EquipamentoBusiness eqb = new EquipamentoBusiness();
			Equipamento equip = eqb.pesquisarEquipamentosPelaMarcaEModelo(equipamento);
			
			if(atendimentoBean.getCliente().getNomeCliente()==null || atendimentoBean.getCliente().getNomeCliente()!= null
					||atendimentoBean.getCliente().getNomeCliente().trim().equals("")){
	        	ClienteBusiness clb = new ClienteBusiness();
	        	cliente = clb.pesquisarClientePorAtendimento(atendimentoBean.getAtendimento());
	        	
	        }else{
			    //salvar cliente equipamento
			    ClienteBusiness clienteBusiness = new ClienteBusiness();
			    cliente = clienteBusiness.pesquisaClienteNome(cliente);
	        }
			ClienteEquipamentoBusiness clieqbus = new ClienteEquipamentoBusiness();
			clienteEquipamento.setCliente(cliente);
			clienteEquipamento.setEquipamento(equip);
			clieqbus.salvarClienteEquipamento(clienteEquipamento);
			
			//salvar atendimento
			atendimento.setStatusPendencia(Constantes.STATUS_ENCERRADO);
						
			atendimento.setHoraChegada(Utils.formataDataHoraAtendimento(atendimento.getDataFechamento(),horaAtendimentoEntrada));
			atendimento.setHoraSaida(Utils.formataDataHoraAtendimento(atendimento.getDataFechamento(),horaAtendimentoSaida));
			
			atm.salvarAtendimento(atendimento);
			
			ItemAtendimentoBusiness atbus = new ItemAtendimentoBusiness(); 
			
			for(ItemEquipamento ite : itensManutencao){
			   
			   ItemAtendimento iter = new ItemAtendimento();
			   ItemEquipamentoBusiness buss = new ItemEquipamentoBusiness();
               iter.setQuantidadeSubstituida(ite.getQuantidade());
               iter.setMotivoSubstituicao(ite.getDesSitEqip());
			   ite = buss.buscarItemPeloNome(ite);
               iter.setItemEquipamento(ite);
               iter.setAtendimento(atendimento);
			   atbus.salvarItemAtendimento(iter);			
			
			}
			
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_INFO, getResourceBundle(context, Constantes.ATENDIMENTO_ENCERRAR_SUCC), null));
		}else{
			
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_FICHA_ERRO), null));
		
		}
	
	}
	
	/**
	 * 
	 * metodo responsavel por colocar o atendimento
	 * sob pendencia
	 * 
	 */
	public void colocarAtendimentoPendencia(){
		
		atendimento.setStatusPendencia("P");
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		AtendimentoBusiness atm = new AtendimentoBusiness();
		
		ClienteEquipamentoBusiness cliEq = new ClienteEquipamentoBusiness();
		
		if(itensManutencao.isEmpty()){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_ITENS_ERRO), null));
		}else if(!atm.validateHora(horaAtendimentoEntrada)){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_HORA_ENT_ERRO), null));
			
		}else if(!atm.validateHora(horaAtendimentoSaida)){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_HORA_SAI_ERRO), null));
		}else if(!cliEq.validateClienteEquipamento(clienteEquipamento)){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_FICHA_ERRO), null));
		}else if(equipamento.getMarcaEquipamento().equals("") || equipamento.getNumModelo() == 0){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_FICHA_ERRO), null));
		}else if(atm.validateFichaAtendimento(atendimento)){
			
			//salvar equipamento
			
			EquipamentoBusiness eqb = new EquipamentoBusiness();
			Equipamento equip = eqb.pesquisarEquipamentosPelaMarcaEModelo(equipamento);
			
			if(atendimentoBean.getCliente().getNomeCliente()==null || atendimentoBean.getCliente().getNomeCliente()!= null
					||atendimentoBean.getCliente().getNomeCliente().trim().equals("")){
	        	ClienteBusiness clb = new ClienteBusiness();
	        	cliente = clb.pesquisarClientePorAtendimento(atendimentoBean.getAtendimento());
	        	
	        }else{
			    //salvar cliente equipamento
			    ClienteBusiness clienteBusiness = new ClienteBusiness();
			    cliente = clienteBusiness.pesquisaClienteNome(cliente);
	        }
			
			ClienteEquipamentoBusiness clieqbus = new ClienteEquipamentoBusiness();
			clienteEquipamento.setCliente(cliente);
			clienteEquipamento.setEquipamento(equip);
			clieqbus.salvarClienteEquipamento(clienteEquipamento);
			
			//salvar atendimento
			atendimento.setStatusPendencia(Constantes.STATUS_PENDENTE);
						
			atendimento.setHoraChegada(Utils.formataDataHoraAtendimento(atendimento.getDataFechamento(),horaAtendimentoEntrada));
			atendimento.setHoraSaida(Utils.formataDataHoraAtendimento(atendimento.getDataFechamento(),horaAtendimentoSaida));
			
			atm.salvarAtendimento(atendimento);
			
			ItemAtendimentoBusiness atbus = new ItemAtendimentoBusiness(); 
			
			for(ItemEquipamento ite : itensManutencao){
			   
			   ItemAtendimento iter = new ItemAtendimento();
			   ItemEquipamentoBusiness buss = new ItemEquipamentoBusiness();
			   ite = buss.buscarItemPeloNome(ite);
               iter.setItemEquipamento(ite);
               iter.setAtendimento(atendimento);
			   atbus.salvarItemAtendimento(iter);			
			
			}
			
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_INFO, getResourceBundle(context, Constantes.ATENDIMENTO_PENDENCIA_SUCC), null));
		}else{
			
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_FICHA_ERRO), null));
		
		}
	}
	
	/**
	 * 
	 * metodo responsavel por remover
	 * o item da ficha de atendimento tecnico
	 * 
	 */
	public void excluirItemFicha(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		String itm = context.getExternalContext().getRequestParameterMap().get("nomeEq"); 
		
		ArrayList<ItemEquipamento> newit = new ArrayList<ItemEquipamento>();
		for(ItemEquipamento item:itensManutencao){
			if(!item.getNomeItem().equals(itm)){
				newit.add(item);
			}
		}
		itensManutencao = newit;
		
	}
	
	/**
	 * 
	 * metodo responsavel por adicionar um novo item
	 * na ficha de atendimento
	 * 
	 */
	public void adicionarItemFichaAtendimento(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		ItemEquipamento itm = new ItemEquipamento();
		itm.setNomeItem(itemEquipamento.getNomeItem());
		itm.setQuantidade(itemAtendimento.getQuantidadeSubstituida());
		itm.setDesSitEqip(itemAtendimento.getMotivoSubstituicao());
		
		boolean existeLista = false;
		for(ItemEquipamento it : itensManutencao){
			if(it.getNomeItem().equals(itemEquipamento.getNomeItem())){
				existeLista = true;
			}
		}
		
		if(existeLista){
			context.addMessage("msgs", 
					   new FacesMessage(FacesMessage.SEVERITY_ERROR, getResourceBundle(context, Constantes.ATENDIMENTO_ITEM_EXISTENTE), null));
		}else{
		   itensManutencao.add(itm);
		}
		nomeItem = "";
		itemEquipamento = new ItemEquipamento();
		itemAtendimento = new ItemAtendimento();
		
	}
	
	
	/**
	 * 
	 * metodo responsavel por carregar a combo com os 
	 * nomes dos modelos para os equipamentos selecionados
	 * 
	 * @param event
	 */
	public void carregaComboNomeModelo(AjaxBehaviorEvent event){
	    
        EquipamentoBusiness eqp = new EquipamentoBusiness();
	    
	    modeloElevador.clear();
	    
		List<Equipamento>equipmod = eqp.pesquisarEquipamentosPelaMarca(equipamento);
	    
		for(Equipamento equipamento: equipmod){
	    	SelectItem items = new SelectItem();
	    	items.setValue(equipamento.getNumModelo());
	    	items.setLabel(equipamento.getNomeModelo());
	    	modeloElevador.add(items);
	    }
	 
	}
	
	
	/**
	 * 
	 * método responsavel por carregar o chamado selecionado pelo cliente
	 * na tabela de chamados
	 * 
	 * @return
	 */
	
	public String detalharChamado(){
		
		limparSessao();
		
        ClienteBusiness clienteBusiness = new ClienteBusiness();
        
        if(atendimentoBean.getCliente().getNomeCliente()==null || atendimentoBean.getCliente().getNomeCliente().trim().equals("")){
        	ClienteBusiness clb = new ClienteBusiness();
        	Cliente clie = clb.pesquisarClientePorAtendimento(atendimentoBean.getAtendimento());
        	cliente.setNomeCliente(clie.getNomeCliente());
        }else{
        
        	cliente.setNomeCliente(atendimentoBean.getCliente().getNomeCliente());
        	
        }
        
        cliente = clienteBusiness.pesquisaClienteNome(cliente);
	    
	    AtendimentoBusiness atendimentoBusiness = new AtendimentoBusiness();
	    
	    atendimento.setNumeroSS(atendimentoBean.getAtendimento().getNumeroSS());
	    
	    atendimento = atendimentoBusiness.pesquisaAtendimentoPorClienteDataSS(cliente, atendimento).get(0);
	    
	    ItemAtendimentoBusiness itemab = new ItemAtendimentoBusiness();
	    ItemAtendimento itema = new ItemAtendimento();
	    itema.setAtendimento(atendimento);
	    List<ItemAtendimento> lista = itemab.buscarItemPeloNumeroSSAtendimento(itema);
	    
	    for(ItemAtendimento ima: lista){
	    	ItemEquipamento ite = new ItemEquipamento();
	    	ite.setNomeItem(ima.getItemEquipamento().getNomeItem());
	    	ite.setDesSitEqip(ima.getMotivoSubstituicao());
	    	ite.setQuantidade(ima.getQuantidadeSubstituida());
	    	itensManutencao.add(ite);
	    	
	    }
	    
	    EquipamentoBusiness equipamentoBusiness = new EquipamentoBusiness();
	    
	    List<Equipamento>equipamentos = equipamentoBusiness.pesquisarEquipamentos();
	    
	    for(Equipamento equipamento: equipamentos){
	    	SelectItem item = new SelectItem();
	    	item.setValue(equipamento.getMarcaEquipamento().toUpperCase());
	    	item.setLabel(equipamento.getMarcaEquipamento().toUpperCase());
	    	marcaElevador.add(item);
	    }
        
	    return "success";
	}
	
	/**
	 * 
	 * metodo responsavel por pesquisar os itens
	 * para a ficha de atendimento
	 * 
	 */
	
	public void pesquisarItens(){
		
		ItemEquipamentoBusiness bus = new ItemEquipamentoBusiness();
		itemEquipamento.setNomeItem(nomeItem);
		itemEquipamento = bus.buscarItemPeloNome(itemEquipamento);
		if(itemEquipamento == null){
			itemEquipamento = new ItemEquipamento();
			nomeItem = "";
		}
	}
	
	/**
	 * limpa a sessao ao carregar a tela
	 */
	public void limparSessao(){
		
		atendimento = new Atendimento();
		cliente = new Cliente();
		equipamento = new Equipamento();
		clienteEquipamento = new ClienteEquipamento();
		itemEquipamento = new ItemEquipamento();
		itemAtendimento = new ItemAtendimento();
		horaAtendimentoEntrada = "";
		horaAtendimentoSaida = "";
		nomeItem = "";
		marcaElevador.clear();
	    modeloElevador.clear();
	    itensManutencao.clear();
	}
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteEquipamento getClienteEquipamento() {
		return clienteEquipamento;
	}

	public void setClienteEquipamento(ClienteEquipamento clienteEquipamento) {
		this.clienteEquipamento = clienteEquipamento;
	}

	public String getHoraAtendimentoEntrada() {
		return horaAtendimentoEntrada;
	}

	public void setHoraAtendimentoEntrada(String horaAtendimentoEntrada) {
		this.horaAtendimentoEntrada = horaAtendimentoEntrada;
	}

	public String getHoraAtendimentoSaida() {
		return horaAtendimentoSaida;
	}

	public void setHoraAtendimentoSaida(String horaAtendimentoSaida) {
		this.horaAtendimentoSaida = horaAtendimentoSaida;
	}

	public List<SelectItem> getMarcaElevador() {
		return marcaElevador;
	}

	public void setMarcaElevador(List<SelectItem> marcaElevador) {
		this.marcaElevador = marcaElevador;
	}

	public List<SelectItem> getModeloElevador() {
		return modeloElevador;
	}

	public void setModeloElevador(List<SelectItem> modeloElevador) {
		this.modeloElevador = modeloElevador;
	}

	public AtendimentoBean getAtendimentoBean() {
		return atendimentoBean;
	}

	public void setAtendimentoBean(AtendimentoBean atendimentoBean) {
		this.atendimentoBean = atendimentoBean;
	}

	public List<ItemEquipamento> getItensManutencao() {
		return itensManutencao;
	}

	public void setItensManutencao(List<ItemEquipamento> itensManutencao) {
		this.itensManutencao = itensManutencao;
	}
	
	public ItemEquipamento getItemEquipamento() {
		return itemEquipamento;
	}

	public void setItemEquipamento(ItemEquipamento itemEquipamento) {
		this.itemEquipamento = itemEquipamento;
	}
	
	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	
	public ItemAtendimento getItemAtendimento() {
		return itemAtendimento;
	}

	public void setItemAtendimento(ItemAtendimento itemAtendimento) {
		this.itemAtendimento = itemAtendimento;
	}
	
}
