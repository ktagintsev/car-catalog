/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 3:25
 * To change this template use File | Settings | File Templates.
 */
Ext.define('CarCatalog.model.CarCatalogModel', {
    extend: 'Ext.data.Model',
    fields: ['name', 'price'],
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
            writeAllFields: true,
            writeRecordId: false
        }

    }
});