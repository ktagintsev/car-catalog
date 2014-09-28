/**
 * Created by ktagintsev on 27.09.14.
 */
Ext.define('CarCatalog.controller.CarCatalogController', {
    extend: 'Ext.app.Controller',

    refs: [
        {selector: 'carGridView',
            ref: 'carGridView'},
        {selector: 'carGridView button[action="add"]',
            ref: 'carGridAdd'},
        {selector: 'carGridView button[action="delete"]',
            ref: 'carGridDelete'},
        {selector: 'searchCarView button[action="search"]',
            ref: 'searchCar'},
        {selector: 'addCarFormView',
            ref: 'addCarFormView'},
        {selector: 'carCatalogView',
            ref: 'carCatalogView'},
        {selector: 'addCarFormView textfield[name=name] ',
            ref: 'addCarFormName'},
        {selector: 'addCarFormView textfield[name=price]',
            ref: 'addCarFormPrice'},
        {selector: 'addCarFormView button[action=save]',
            ref: 'addCarFormSave'}
    ],

    init: function () {
        this.control({
            'carGridView  button[action=add]': {
                click: this.onAddCar
            },
            'carGridView  button[action=delete]': {
                click: this.onDelCar
            },
            'searchCarView  textfield[name="search"]': {
                change: this.onChangeText
            },
            'carGridView': {
                cellclick: this.onLineGrid
            },
            'addCarFormView  button[action=save]': {
                click: this.onSaveCar
            },
            'addCarFormView  textfield[name=name]': {
                change: this.onValidation
            },
            'addCarFormView  textfield[name=price]': {
                change: this.onValidation
            }
        });
    },

    onSaveCar: function (button) {
        var me = this;
        var carModel = Ext.create('CarCatalog.model.CarCatalogModel');
        carModel.set(this.getAddCarFormView().down('form').getValues());
        carModel.save({
            success: function (operation, response) {
                var objAjax = operation.data;
                Ext.getStore('CarCatalogStore').add(objAjax);
                me.getAddCarFormView().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Дубликат!',
                    msg: 'Такая модель и цена уже существуют',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });
    },

    onAddCar: function () {
        Ext.widget('addCarFormView');
    },

    onDelCar: function () {
        var sm = this.getCarGridView().getSelectionModel();
        var rs = sm.getSelection();
        this.getCarGridView().store.remove(rs[0]);
        this.getCarGridView().store.commitChanges();
        this.getCarGridDelete().disable();
    },

    onChangeText: function () {
        Ext.getStore('CarCatalogStore').load({
            params: {
                search: this.getCarCatalogView().down('searchCarView').getValues()
            }
        });
    },

    onLineGrid: function () {
        this.getCarGridDelete().enable();
    },

    onValidation: function () {
        if (this.getAddCarFormName().validate() && this.getAddCarFormPrice().validate()) {
            this.getAddCarFormSave().enable();
        } else {
            this.getAddCarFormSave().disable();
        }
    }

});