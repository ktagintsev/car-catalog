/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 3:28
 * To change this template use File | Settings | File Templates.
 */
Ext.define('CarCatalog.store.CarCatalogStore', {
    extend: 'Ext.data.Store',
    requires : [
        'CarCatalog.model.CarCatalogModel'
    ],
    model: 'CarCatalog.model.CarCatalogModel',
    autoLoad: true,
    autoSync: true,
    proxy: {
        type: 'rest',
        api: {
            create: 'car',
            read: 'car',
            destroy: 'car',
            update: 'car'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    }
});