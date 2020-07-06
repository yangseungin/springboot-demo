package com.giantdwarf.springbootdemo.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    public EntityModel<Hateoas> hateoas(){

        Hateoas hateoas = new Hateoas();
        hateoas.setPrefix("hey, ");
        hateoas.setName("seungin");

//        EntityModel<Hateoas> hateoasEntityModel = new EntityModel<>(hateoas); //deprecated
        EntityModel<Hateoas> hateoasEntityModel = EntityModel.of(hateoas);
        hateoasEntityModel.add(linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());

        return hateoasEntityModel;
    }
    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomerById(@PathVariable String id){
        //exist customer
        Customer customer = new Customer();
        customer.setId("giant");
        customer.setName("seungin");
        customer.setCompanyName("Hell company");

        EntityModel<Customer> model = EntityModel.of(customer);
        model.add(linkTo(methodOn(HateoasController.class).getCustomerById("giant")).withSelfRel());
        return model;
    }
}
