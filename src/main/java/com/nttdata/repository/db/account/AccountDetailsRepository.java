package com.nttdata.repository.db.account;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailsRepository extends CrudRepository<AccountDetails, Long> {

    @Query("SELECT * FROM Account")
    List<AccountDetails> findAll();



}
