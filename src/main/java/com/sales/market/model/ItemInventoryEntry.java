/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market.model;

import com.sales.market.dto.ItemInventoryDto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class ItemInventoryEntry extends ModelBase<ItemInventoryDto>{
    @OneToOne
    private ItemInventory itemInventory;
    @OneToOne
    private ProviderItem providerItem;
    private MovementType movementType;
    private BigDecimal quantity; // representan la cantidad de instancias de venta o compra
    private String itemInstanceSkus; //representa una lista del sku de las instancias de elementos involucrados

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(ItemInventory itemInventory) {
        this.itemInventory = itemInventory;
    }

    public ProviderItem getProviderItem() {
        return providerItem;
    }

    public void setProviderItem(ProviderItem providerItem) {
        this.providerItem = providerItem;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getItemInstanceSkus() {
        return itemInstanceSkus;
    }

    public void setItemInstanceSkus(String itemInstanceSkus) {
        this.itemInstanceSkus = itemInstanceSkus;
    }
    /*
    Tenga en cuenta que el sku no se puede duplicar
    En el servicio hacer posible: registrar instancias
    de compra de artículos-> Si no existe el producto crearlo, registrar instancias,
                                        crear y actualizar el ItemInventory correspondiente con sus totalizados
                                        Generar los ItemInventoryEntry para reflejar la operacion de entrada o salida
                                         de almacen

       vender un producto
       desechar un producto similar a una venta pero a costo 0. Debe reflejar el totalizado correctamente de
       ItemInventory

       Debe haber tests unitarios que muestren escenarios para estas operaciones en casos de exito y de error.
    */
}
