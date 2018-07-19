package com.brainmatic.pos.core.entity.repo.entityrepo;

import com.brainmatic.pos.core.entity.Sale;
import com.brainmatic.pos.core.entity.repo.RepositoryNonSpring;

public interface SaleRepo extends RepositoryNonSpring<Sale> {
    Sale getByIdEager(int id);
}
