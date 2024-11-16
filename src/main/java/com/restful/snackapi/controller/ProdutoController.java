package com.restful.snackapi.controller;
import com.restful.snackapi.model.Produto;
import com.restful.snackapi.service.ImageUploadService;
import com.restful.snackapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ImageUploadService imageUploadService;

    // Listando todos os produtos
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    // Buscando o produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Produto produto = produtoService.getProdutoById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    // Criando um produto
    @PostMapping
    public ResponseEntity<Produto> createProduto(
            @RequestParam("nome") String nome,
            @RequestParam("descricao") String descricao,
            @RequestParam("preco") Double preco,
            @RequestParam("categoria") String categoria,
            @RequestParam("imagem") MultipartFile imagem,
            @RequestParam("quantidade") Integer quantidade) {  // Adicionado parâmetro de quantidade

        try {
            // Upload da imagem e obtenção da URL
            String imageUrl = imageUploadService.uploadImage(imagem);

            Produto produto = new Produto();
            produto.setNome_Produto(nome);
            produto.setDescricao(descricao);
            produto.setPreco_Produto(preco);
            produto.setCategoria(categoria);
            produto.setImageUrl(imageUrl);
            produto.setQntd_Produto(quantidade);  // Definindo a quantidade do produto

            Produto savedProduto = produtoService.saveProduto(produto);
            return ResponseEntity.ok(savedProduto);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Deletando um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Produto existingProduto = produtoService.getProdutoById(id);
        if (existingProduto == null) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    // Upload de imagem do produto
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImagem(@RequestParam("file")MultipartFile file) {
        try {
            String imageUrl = imageUploadService.uploadImage(file);
            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao fazer o upload de imagem");
        }

    }
}


