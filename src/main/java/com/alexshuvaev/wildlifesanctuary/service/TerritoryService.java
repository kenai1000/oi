package com.alexshuvaev.wildlifesanctuary.service;

import com.alexshuvaev.wildlifesanctuary.entity.Territory;
import com.alexshuvaev.wildlifesanctuary.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerritoryService extends AbstractService<Territory> implements RootService<Territory> {

    @Autowired
    public TerritoryService(@Qualifier("territoryRepository") RootRepository<Territory> repository) {
        super(repository);
    }

    @Override
    public List<Territory> getAll(Pageable pageRequest) {
        return super.getAll(pageRequest);
    }

    @Override
    public Territory get(int id) {
        return super.get(id);
    }

    @Override
    public Territory create(Territory creatable) {
        return super.create(creatable);
    }

    @Override
    public Territory update(Territory updatable, int id) {
        return super.update(updatable, id);
    }

    @Override
    public Boolean delete(int id) {
        return super.delete(id);
    }
}
