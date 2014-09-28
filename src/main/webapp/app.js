/**
 * Created by ktagintsev on 26.09.14.
 */
Ext.application({
    name: 'CarCatalog',

    views: [
        'AddCarFormView',
        'CarCatalogView',
        'CarGridView',
        'SearchCarView'
    ],

    controllers : [
        'CarCatalogController'
    ],

    stores : [
        'CarCatalogStore'
    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype  : 'carCatalogView'
            }
        });
    }
});