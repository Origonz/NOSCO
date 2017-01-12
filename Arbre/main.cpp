#include "mainwindow.h"
#include <QApplication>
#include <QtGui>
#include<QFileSystemModel>
#include<QTreeView>
 int main(int argc, char *argv[])
 {
     QApplication app(argc, argv);

     QFileSystemModel *model = new QFileSystemModel;
     model->setRootPath("/home/origon/");
     QTreeView tree;
     //tree.header()->setResizeMode(0, QHeaderView::ResizeToContents);
     tree.setModel(model);

     // Demonstrating look and feel features
     tree.setAnimated(false);
     tree.setIndentation(20);
     tree.setSortingEnabled(true);

     tree.setWindowTitle(QObject::tr("Dir View"));
     tree.resize(640, 480);
     tree.;
     tree.show();

     return app.exec();
 }
