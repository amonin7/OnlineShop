package main.controllers;

import com.google.gson.Gson;
import main.entities.GoodEntity;
import main.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@Controller
public class RestController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("/allGoods")
    public @ResponseBody Iterable<GoodEntity> getAllGoods() {
        return goodsRepository.findAll();
    }

    @PostMapping(value = "/addGood", headers = "Accept=application/json")
    public @ResponseBody String addGood(@RequestBody GoodEntity goodEntity) {

        goodsRepository.save(goodEntity);
        ResponseEntity response = new ResponseEntity("Saved", true);
        return new Gson().toJson(response);
    }

    @DeleteMapping(value = "/goodById")
    public @ResponseBody String deleteGood(@RequestParam Long id) {
        Optional<GoodEntity> good = goodsRepository.findById(id);
        ResponseEntity response;
        if (good.isPresent()) {
            goodsRepository.delete( good.get() );
            response = new ResponseEntity("Deleted", true);
            return new Gson().toJson(response);
        } else {
            response = new ResponseEntity("There is no good with such id", true);
            return new Gson().toJson(response);
        }
    }

    @GetMapping("/goodById")
    public @ResponseBody String getGood(@RequestParam Long id) {
        Optional<GoodEntity> good = goodsRepository.findById(id);

        if (good.isPresent()) {
            return new Gson().toJson(good);
        } else {
            ResponseEntity response = new ResponseEntity("No Such Good", false);
            return new Gson().toJson(response);
        }
    }

    @PutMapping("/good")
    public @ResponseBody String editGood(
            @RequestParam(name="id", required = false) Long id,
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="code", required = false) BigInteger code,
            @RequestParam(name="category", required = false) String category) {
        Optional<GoodEntity> good;
        if (name != null && goodsRepository.findFirstByName(name).isPresent())
            good = goodsRepository.findFirstByName(name);
        else if (code != null && goodsRepository.findFirstByCode(code).isPresent())
            good = goodsRepository.findFirstByCode(code);
        else if (category != null && goodsRepository.findFirstByCategory(category).isPresent())
            good = goodsRepository.findFirstByCategory(category);
        else
            good = goodsRepository.findById(id);

        ResponseEntity response;

        if (good.isPresent()) {
            GoodEntity foundGood = good.get();
            goodsRepository.save(foundGood.updateGood(name, code, category));
            response = new ResponseEntity("Updated", true);
            return new Gson().toJson(response);
        } else {
            response = new ResponseEntity("No Such Good", false);
            return new Gson().toJson(response);
        }
    }

}
