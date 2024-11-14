package com.restful.snackapi.service;
import com.restful.snackapi.model.Produto;
import com.restful.snackapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    private static final String IMAGE_DIRECTORY = "";

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarProdutosPorCategoria(String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }


}