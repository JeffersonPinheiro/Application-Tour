package com.acme.tour.repository

import com.acme.tour.model.Promocao
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface PromocaoRepository: PagingAndSortingRepository<Promocao, Long> {
    @Query(value= "select p from Promocao p where p.preco <= :preco and p.qtdDias > :dias")
    fun findByPrecoMenorQue(@Param("preco") preco: Double, @Param("dias") qtdDias: Int): List<Promocao>
    @Query(value = "select p from Promocao p where p.local IN :names")
    fun findByLocalInList(@Param("names")names : List<String>): List<Promocao>

    @Query(value = "UPDATE Promocao p set p.preco = :valor WHERE p.local = :local")
    @Transactional @Modifying
    fun updateByLocal(@Param("valor") preco: Double, @Param("local") local: String)
}