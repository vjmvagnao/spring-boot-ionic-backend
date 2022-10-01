package com.vjm.cusomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vjm.cusomc.domain.Categoria;
import com.vjm.cusomc.domain.Cidade;
import com.vjm.cusomc.domain.Cliente;
import com.vjm.cusomc.domain.Endereco;
import com.vjm.cusomc.domain.Estado;
import com.vjm.cusomc.domain.Pagamento;
import com.vjm.cusomc.domain.PagamentoComBoleto;
import com.vjm.cusomc.domain.PagamentoComCartao;
import com.vjm.cusomc.domain.Pedido;
import com.vjm.cusomc.domain.Produto;
import com.vjm.cusomc.domain.enums.EstadoPagamento;
import com.vjm.cusomc.domain.enums.TipoCliente;
import com.vjm.cusomc.repositories.CategariaRepository;
import com.vjm.cusomc.repositories.CidadeRepository;
import com.vjm.cusomc.repositories.ClienteRepository;
import com.vjm.cusomc.repositories.EnderecoRepository;
import com.vjm.cusomc.repositories.EstadoRepository;
import com.vjm.cusomc.repositories.PagamentoRepository;
import com.vjm.cusomc.repositories.PedidoRepository;
import com.vjm.cusomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategariaRepository caregoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria (null, "Informatica");
		Categoria cat2 = new Categoria (null, "Escritorio");
		
		Produto p1 = new Produto (null, "Computador", 2000.0);
		Produto p2 = new Produto (null, "Impressora", 800.0);
		Produto p3 = new Produto (null, "Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		caregoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
				
		est1.getCidades().addAll(Arrays.asList(cid1));		
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","123456789",TipoCliente.PESSOAFISICA);				
		cli1.getTelefones().addAll(Arrays.asList("11111111","22222222"));
		
		Endereco end1 = new Endereco(null,"Rua Flores", "300", "Aptp 303","Jardim", "14820000", cli1, cid1);
		Endereco end2 = new Endereco(null,"Av Mathos", "105", "Sala 800","Centro", "14900000", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);		
		ped1.setPagamento(pgto1);
		
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);		
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
				
		
		
	}

}
