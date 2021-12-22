package org.example.BeerMachine;

import org.example.BeerMachine.service.BatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class BeerMachineApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BatchService batchService;

	@Test
	void contextLoads() {
		assertThat(batchService).isNotNull();
	}

//	@Test
//	public void assertThatCreateBatchWorks() throws Exception {
//		this.mockMvc.perform(post("/"))
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("teste")
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello, World")));
//	}


}
