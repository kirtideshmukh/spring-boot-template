package com.organisation.repository;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.Nullable;

@NoRepositoryBean
public interface VavrFlavouredJpaRepository<T, ID>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

  default List<T> findAllEntities() {
    return List.ofAll(findAll());
  }

  default <S extends T> List<S> findAllEntities(Example<S> example) {
    return List.ofAll(findAll(example));
  }

  default List<T> findAllEntities(@Nullable Specification<T> spec) {
    return List.ofAll(findAll(spec));
  }

  default List<T> findAllEntitiesById(Iterable<ID> ids) {
    return List.ofAll(findAllById(ids));
  }

  default <S extends T> List<S> saveAllEntities(Iterable<S> entities) {
    return List.ofAll(saveAll(entities));
  }

  default Option<T> findEntityById(ID id) {
    return Option.ofOptional(findById(id));
  }
}
