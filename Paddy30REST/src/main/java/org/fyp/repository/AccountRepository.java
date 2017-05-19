package org.fyp.repository;

import org.fyp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

//@RepositoryRestResource(collectionResourceRel = "account", path = "Accounts")
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountId(Integer accountId);
    Account findByEmail(String email);
    Account findByPassword(String password);

    Integer deleteAccountByAccountId(Integer accountId);
}