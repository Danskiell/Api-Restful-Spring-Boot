package com.restful.snackapi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Produto;

    @Column(name = "nome_Produto", nullable = false)
    private String nome_Produto;

    @Column(name = "preco_Produto", nullable = false)
    private Double preco_Produto;

    @Column(name = "qntd_Produto", nullable = false)
    private Integer qntd_Produto;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_Movimentacao_Id_Mov", nullable = false)
    private Movimentacao movimentacao;

    @ManyToOne
    @JoinColumn(name = "fk_categProd_id_Categ", nullable = false)
    private Categ_Prod categ_prod;

    @Column(name = "image_url")
    private String imageUrl;

    public Long getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(Long id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public Double getPreco_Produto() {
        return preco_Produto;
    }

    public void setPreco_Produto(Double preco_Produto) {
        this.preco_Produto = preco_Produto;
    }

    public Integer getQntd_Produto() {
        return qntd_Produto;
    }

    public void setQntd_Produto(Integer qntd_Produto) {
        this.qntd_Produto = qntd_Produto;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Categ_Prod getCateg_prod() {
        return categ_prod;
    }

    public void setCateg_prod(Categ_Prod categ_prod) {
        this.categ_prod = categ_prod;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

