package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
