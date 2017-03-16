package com.unelev.projetosia.dao;



import java.util.Date;




import com.unelev.projetosia.business.ClienteBusiness;
import com.unelev.projetosia.business.ControleAcesso;
import com.unelev.projetosia.business.EquipamentoBusiness;
import com.unelev.projetosia.business.ItemEquipamentoBusiness;
import com.unelev.projetosia.business.SubsistemaBusiness;
import com.unelev.projetosia.entity.Atendente;
import com.unelev.projetosia.entity.Cliente;
import com.unelev.projetosia.entity.Equipamento;
import com.unelev.projetosia.entity.ItemEquipamento;
import com.unelev.projetosia.entity.Subsistema;

public class Teste {

	public static void main(String[] args) {
		/*Employee empl = new Employee();
		empl.setFirstName("fbfghgfh");
		empl.setLastName("dfggfgdfg");
		empl.setSalary(1234);
		
		BaseDAO base = new BaseDAO();
	    base.salvar(empl);
		System.out.println(empl.getId());*/
		
		Atendente a = new Atendente();
		a.setCpfAtendente(new Long("05854283956"));
		a.setDataEfetivacao(new Date());
		a.setDataNascimento(new Date());
		a.setNomeAtendente("joao herbert fontenele cordeiro");
		a.setRgAtendente(new Long("71835545"));
		a.setPassAtendente("filp01fl");
		
		ControleAcesso ac = new ControleAcesso();
		ac.salvarAtendente(a);
		
		
		Cliente cli = new Cliente();
		cli.setCnpjCliente(new Long("44148821000145"));
		cli.setNomeCliente("COND. EDIF. CEZIRA");
        cli.setEnderecoCliente("rua numero dois");
        cli.setComplCliente("apto 13");
        cli.setRespCliente("Jose dos Santos");
        cli.setDddTelCliente(new Integer(41));
        cli.setNumTelCliente(new Long("4130223871"));
        cli.setDddCelCliente(new Integer(41));
        cli.setCelCliente(new Long("4188021217"));
		
        ClienteBusiness buss = new ClienteBusiness();
        buss.salvarCliente(cli);

		Cliente cli1 = new Cliente();
		cli1.setCnpjCliente(new Long("35013565000199"));
		cli1.setNomeCliente("EDIFICIO TESTE");
        cli1.setEnderecoCliente("rua numero dois");
        cli1.setNumEnd(new Integer(1071));
        cli1.setComplCliente("apto 13");
        cli1.setRespCliente("Jose dos Santos");
        cli1.setDddTelCliente(new Integer(41));
        cli1.setNumTelCliente(new Long("4130223871"));
        cli1.setDddCelCliente(new Integer(41));
        cli1.setCelCliente(new Long("4188021217"));
		
        buss.salvarCliente(cli1);
        
        Cliente cli2 = new Cliente();
		cli2.setCnpjCliente(new Long("47641557000175"));
		cli2.setNomeCliente("COND. EDIF. PARANA");
        cli2.setEnderecoCliente("rua numero dois");
        cli2.setNumEnd(new Integer(1071));
        cli2.setComplCliente("apto 13");
        cli2.setRespCliente("Jose dos Santos");
        cli2.setDddTelCliente(new Integer(41));
        cli2.setNumTelCliente(new Long("4130223871"));
        cli2.setDddCelCliente(new Integer(41));
        cli2.setCelCliente(new Long("4188021217"));
		
        buss.salvarCliente(cli2);
        
        Cliente cli3 = new Cliente();
    	cli3.setCnpjCliente(new Long("91773214000156"));
    	cli3.setNomeCliente("COND. EDIF. RIO PARANA");
        cli3.setEnderecoCliente("rua numero dois");
        cli3.setNumEnd(new Integer(1071));
        cli3.setComplCliente("apto 13");
        cli3.setRespCliente("Jose dos Santos");
        cli3.setDddTelCliente(new Integer(41));
        cli3.setNumTelCliente(new Long("4130223871"));
        cli3.setDddCelCliente(new Integer(41));
        cli3.setCelCliente(new Long("4188021217"));
    		
        buss.salvarCliente(cli3);
        
        
        Cliente cli4 = new Cliente();
    	cli4.setCnpjCliente(new Long("86646699000187"));
    	cli4.setNomeCliente("COND. EDIF. BONARDA");
        cli4.setEnderecoCliente("rua numero dois");
        cli4.setNumEnd(new Integer(1071));
        cli4.setComplCliente("apto 13");
        cli4.setRespCliente("Jose dos Santos");
        cli4.setDddTelCliente(new Integer(41));
        cli4.setNumTelCliente(new Long("4130223871"));
        cli4.setDddCelCliente(new Integer(41));
        cli4.setCelCliente(new Long("4188021217"));
    		
        buss.salvarCliente(cli4);
        
        Cliente cli5 = new Cliente();
    	cli5.setCnpjCliente(new Long("42148286000105"));
    	cli5.setNomeCliente("COND. EDIF. SORAYA");
        cli5.setEnderecoCliente("rua numero dois");
        cli5.setNumEnd(new Integer(1071));
        cli5.setComplCliente("apto 13");
        cli5.setRespCliente("Jose dos Santos");
        cli5.setDddTelCliente(new Integer(41));
        cli5.setNumTelCliente(new Long("4130223871"));
        cli5.setDddCelCliente(new Integer(41));
        cli5.setCelCliente(new Long("4188021217"));
    		
        buss.salvarCliente(cli5);
        
        Cliente cli6 = new Cliente();
    	cli6.setCnpjCliente(new Long("48594265000191"));
    	cli6.setNomeCliente("COND. EDIF. MARSELHA II");
        cli6.setEnderecoCliente("rua numero dois");
        cli6.setNumEnd(new Integer(1071));
        cli6.setComplCliente("apto 13");
        cli6.setRespCliente("Jose dos Santos");
        cli6.setDddTelCliente(new Integer(41));
        cli6.setNumTelCliente(new Long("4130223871"));
        cli6.setDddCelCliente(new Integer(41));
        cli6.setCelCliente(new Long("4188021217"));
    		
        buss.salvarCliente(cli6);

        Cliente cli7 = new Cliente();
    	cli7.setCnpjCliente(new Long("84767745000170"));
    	cli7.setNomeCliente("COND. EDIF. ROYAL PARK");
        cli7.setEnderecoCliente("rua numero dois");
        cli7.setNumEnd(new Integer(1071));
        cli7.setComplCliente("apto 13");
        cli7.setRespCliente("Jose dos Santos");
        cli7.setDddTelCliente(new Integer(41));
        cli7.setNumTelCliente(new Long("4130223871"));
        cli7.setDddCelCliente(new Integer(41));
        cli7.setCelCliente(new Long("4188021217"));
    		
        buss.salvarCliente(cli7);
        
        Cliente cli8 = new Cliente();
    	cli8.setCnpjCliente(new Long("86044334000182"));
    	cli8.setNomeCliente("COND. EDIF. SAN SEBASTIAN");
        cli8.setEnderecoCliente("rua numero dois");
        cli8.setNumEnd(new Integer(1071));
        cli8.setComplCliente("apto 13");
        cli8.setRespCliente("Jose dos Santos");
        cli8.setDddTelCliente(new Integer(41));
        cli8.setNumTelCliente(new Long("4130223871"));
        cli8.setDddCelCliente(new Integer(41));
        cli8.setCelCliente(new Long("4188021217"));
    		
        buss.salvarCliente(cli8);
        
        EquipamentoBusiness busseq = new EquipamentoBusiness();
        Equipamento equip = new Equipamento();
        equip.setNumModelo(new Integer(1));
        equip.setNomeModelo("Omicron".toUpperCase());
        equip.setMarcaEquipamento("Atlas Schindler".toUpperCase());
        busseq.salvarEquipamento(equip);
        
        Equipamento equip0 = new Equipamento();
        equip0.setNumModelo(new Integer(2));
        equip0.setNomeModelo("Miconic".toUpperCase());
        equip0.setMarcaEquipamento("Atlas Schindler".toUpperCase());
        busseq.salvarEquipamento(equip0);
        
        
        Equipamento equip1 = new Equipamento();
        equip1.setNumModelo(new Integer(3));
        equip1.setNomeModelo("ADV-DP".toUpperCase());
        equip1.setMarcaEquipamento("Otis".toUpperCase());
        busseq.salvarEquipamento(equip1);
        
        Equipamento equip2 = new Equipamento();
        equip2.setNumModelo(new Integer(4));
        equip2.setNomeModelo("Superdyne".toUpperCase());
        equip2.setMarcaEquipamento("Thyssen Krupp".toUpperCase());
        busseq.salvarEquipamento(equip2); 
        
        SubsistemaBusiness subsis = new SubsistemaBusiness();
        
        Subsistema sub = new Subsistema();
        sub.setCodSubsistema(new Integer(1));
        sub.setNomeSubsistema("portas".toUpperCase());
        subsis.salvarSubsistema(sub);
        
        ItemEquipamentoBusiness eqpi = new ItemEquipamentoBusiness();
        
        ItemEquipamento it1 = new ItemEquipamento();
        it1.setEquipNum(new Long(1));
        it1.setNomeItem("dictador".toUpperCase());
        it1.setEquipamento(equip0);
        it1.setSubsistema(sub);
        eqpi.salvarItemEquipamento(it1);
        
        ItemEquipamento it4 = new ItemEquipamento();
        it4.setEquipNum(new Long(2));
        it4.setNomeItem("fecho".toUpperCase());
        it4.setEquipamento(equip0);
        it4.setSubsistema(sub);
        eqpi.salvarItemEquipamento(it4);
        
        ItemEquipamento it5 = new ItemEquipamento();
        it5.setEquipNum(new Long(3));
        it5.setNomeItem("rele".toUpperCase());
        it5.setEquipamento(equip0);
        it5.setSubsistema(sub);
        eqpi.salvarItemEquipamento(it5);
        
        ItemEquipamento it2 = new ItemEquipamento();
        it2.setEquipNum(new Long(4));
        it2.setNomeItem("fecho de porta".toUpperCase());
        it2.setEquipamento(equip2);
        it2.setSubsistema(sub);
        eqpi.salvarItemEquipamento(it2);
        
        ItemEquipamento it3 = new ItemEquipamento();
        it3.setEquipNum(new Long(5));
        it3.setNomeItem("trinco de segurança".toUpperCase());
        it3.setEquipamento(equip1);
        it3.setSubsistema(sub);
        eqpi.salvarItemEquipamento(it3);
        
        /*Atendimento at = new Atendimento();
        at.setDataAbertura(new Date());
        at.setDataFechamento(new Date());
        at.setDescricaoProblema("d");
        at.setCliente(cli);
        
        AtendimentoBusiness ath = new AtendimentoBusiness();
        ath.salvarAtendimento(at);*/
		


	}

}
