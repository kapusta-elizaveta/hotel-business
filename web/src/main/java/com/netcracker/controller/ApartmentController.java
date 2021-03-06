package com.netcracker.controller;

import com.netcracker.dto.ApartmentDto;
import com.netcracker.service.ApartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }


    @ApiOperation(value = "Gets apartment  by id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ApartmentDto> getById(@PathVariable("id") Integer id) {
        //log.info("getById , ApartmentController ");
        return new ResponseEntity<>(apartmentService.getById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Gets all apartments")
    @GetMapping()
    public ResponseEntity<List<ApartmentDto>> getAll() {
        //log.info("getAll , ApartmentController");
        return new ResponseEntity<>(apartmentService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Gets apartment by count places and rooms")
    @GetMapping(value = "/filterbycountroomsandcountplaces")
    public ResponseEntity<List<ApartmentDto>> getApartmentsByCountPlacesAndCountRooms
            (@RequestParam(value = "countPlaces") int countPlaces,
             @RequestParam(value = "countRooms") int countRooms) {

        //log.info("getApartmentsByCountPlacesAndCountRooms ,ApartmentController ");
        return new ResponseEntity<>(apartmentService.getApartmentsByCountPlacesAndCountRooms(countPlaces, countRooms),
                HttpStatus.OK);
    }


    @ApiOperation(value = "Gets all cheaper apartments")
    @GetMapping(value = "/filterbyprice")
    public ResponseEntity<List<ApartmentDto>> getCheaperApartments(@RequestParam("price") int price) {
        //log.info("getCheaperApartments , ApartmentController ");
        return new ResponseEntity<>(apartmentService.getCheaperApartments(price),
                HttpStatus.OK);

    }


    @ApiOperation(value = "Gets apartment by count  rooms")
    @GetMapping(value = "/filterbycountrooms")
    public ResponseEntity<List<ApartmentDto>> getByCountRooms(@RequestParam("countRooms") int countRooms) {
        //log.info("getByCountRooms , ApartmentController  ");
        return new ResponseEntity<>(apartmentService.getApartmentsByCountRooms(countRooms),
                HttpStatus.OK);

    }


    @ApiOperation(value = "Gets apartment by count places")
    @GetMapping(value = "/filterbycountplaces")
    public ResponseEntity<List<ApartmentDto>> getApartmentsByCountPlaces(
            @RequestParam("countPlaces") int countPlaces) {

        //log.info("getApartmentsByCountPlaces , ApartmentController");
        return new ResponseEntity<>(apartmentService.getApartmentsByCountPlaces(countPlaces),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Creates apartment")
    @PostMapping()
    public ResponseEntity<ApartmentDto> save(@Validated @RequestBody ApartmentDto apartmentDto) {
        //log.info("save , ApartmentController");
        return new ResponseEntity<>(apartmentService.save(apartmentDto), HttpStatus.CREATED);
    }


    @ApiOperation(value = "Gets apartment by apartment type id")
    @GetMapping(value = "/filterbytypeid")
    public ResponseEntity<List<ApartmentDto>> getApartmentsByApartmentTypes_Id(@RequestParam("typeId") Integer typeId) {
       // log.info("getApartmentsByApartmentTypesId,ApartmentController");
        return new ResponseEntity<>(apartmentService.getApartmentsByApartmentTypesId(typeId),
                HttpStatus.OK);

    }
}
