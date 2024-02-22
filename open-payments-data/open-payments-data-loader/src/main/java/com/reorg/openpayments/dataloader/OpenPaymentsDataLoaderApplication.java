package com.reorg.openpayments.dataloader;

import com.reorg.openpayments.dataloader.service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenPaymentsDataLoaderApplication implements CommandLineRunner {

	@Autowired
	private DataLoaderService dataLoaderService;

	public static void main(String[] args) {
		SpringApplication.run(OpenPaymentsDataLoaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataLoaderService.loadCSV("/Users/yuli.larrota/tmp/PGYR22_P011824/OP_DTL_GNRL_PGYR2022_P01182024.csv");
	}
}
