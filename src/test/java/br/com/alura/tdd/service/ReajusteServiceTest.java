package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	private ReajusteService service;
	private Funcionario func;

	@BeforeEach
	public void inicializar() {
		System.out.println("Inicializar");
		this.service = new ReajusteService();
		this.func = new Funcionario("Lucas", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Antes de todos");
	}
	
	@AfterAll
	public static void DepoisDeTodos() {
		System.out.println("Depois de todos");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoFoiADesejar() {
		service.concederReajuste(func, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), func.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoFoiBom() {
		service.concederReajuste(func, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), func.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoFoiExcelente() {
		service.concederReajuste(func, Desempenho.EXCELENTE);
		assertEquals(new BigDecimal("1200.00"), func.getSalario());
	}

}
