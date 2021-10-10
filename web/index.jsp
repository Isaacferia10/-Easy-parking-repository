<%-- 
    Document   : index
    Created on : 1/10/2021, 08:53:58 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>  
        <title>home</title>
    </head>
    <style  type="text/css">
        
    </style>
    <body>
        <div class="container-fluid" ng-app = "Easyparking" ng-controller = "registrosController as cn">
            <div> <h3>Easy Parking</h3></div>
            <br>
            <div class="row">
                <div class="col-sm-8" >
                    
                    <div class="card" >
                        <div class="text-center" style="margin: 10px;"><h5>Ingreso de Datos</h5></div>
                    <form style="margin: 10px;">
                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">id</label>
                          <div class="col-sm-10">
                            <input type="number" class="form-control" placeholder="ingrese el lugar de parqueo" ng-model="cn.id" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="staticEmail" class="col-sm-2 col-form-label">Lugar</label>
                          <div class="col-sm-10">
                            <input type="number" class="form-control" placeholder="ingrese el lugar de parqueo" ng-model="cn.lugar" required>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="inputPassword" class="col-sm-2 col-form-label">Matricula</label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputPassword" placeholder="Ingrese la matricula del vehiculo" ng-model="cn.matricula" required>
                          </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Tipo de vehiculo</label>
                            <div class="col-sm-10">
                                <select class="form-select form-select-mb-8" aria-label=".form-select-sm example" ng-model="cn.tipovehiculo" required>
                                    <option selected>Seleccione el tipo de vehiculo</option>
                                    <option value="1">Automovil</option>
                                    <option value="2">Motocicleta</option>
                                    <option value="3">Bicicleta</option>
                                  </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Hora de entrada</label>
                            <div class="col-sm-10">
                              <input type="time" class="form-control" id="inputPassword" placeholder="Ingrese la hora de entrada del vehiculo" ng-model="cn.hentrada" required>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Hora Salida</label>
                            <div class="col-sm-10">
                              <input type="time" class="form-control" id="inputPassword" placeholder="Ingrese la hora de salida del vehiculo" ng-model="cn.hsalida" required>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Valor de Parqueo</label>
                            <div class="col-sm-10">
                              <input type="number" class="form-control" id="inputPassword" placeholder="Ingrese el valor del parqueo" ng-model="cn.valorparqueo" required>
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputPassword" class="col-sm-2 col-form-label">Fecha</label>
                            <div class="col-sm-10">
                              <input type="date" class="form-control" id="inputPassword" placeholder="Ingrese la fecha de parquo" ng-model="cn.fecha" required>
                            </div>
                          </div>
                      </form>
                    </div>
                        
                </div>
                
                
                <div class="col-sm-4">
                    <div class="col-sm-6">
                        <div class="card" >
                            <div class="text-center" style="margin: 10px;"><h5>Ingreso de Datos</h5></div>
                            <button type="button" style="margin: 10px;" class="btn btn-outline-primary"  ng-click="cn.guardarRegistro()">Guardar</button>
                            <button type="button" style="margin: 10px;" class="btn btn-outline-success"  ng-click="cn.listarRegistro()">Listar</button>
                            <button type="button" style="margin: 10px;" class="btn btn-outline-warning"  ng-click="cn.actualizarRegistro()">Actualizar</button>
                            <br>
                            <br>
                            <button type="button" style="margin: 10px;" class="btn btn-outline-danger"  ng-click="cn.eliminarRegistro()">Eliminar</button>
                                  
                        </div>          
                            
                    </div>
                </div>
                
            </div>
            <br>
            <div class="row">
                <div class="col-sm-10" >
                    <div class="card">
                        <table class="table">
                            <thead class="table-dark" style="text-align: center;">
                              <td>Id</td>
                              <td>Lugar</td>
                              <td>Matricula</td>
                              <td>Tipo</td>
                              <td>Hora Entrada</td>
                              <td>Hora Salida</td>
                              <td>Valor Parqueo</td>
                            </thead>
                            <tbody>
                              <!-- base de datos -->
                              <tr ng-repeat = "registro in cn.registros">  
                                    <td>{{ regsitro.id}}</td>  
                                    <td>{{ regsitro.lugar}}</td>  
                                    <td>{{ regsitro.matricula}}</td>  
                                    <td>{{ regsitro.tipovehiculo}}</td>  
                                    <td>{{ regsitro.hentrada}}</td>  
                                    <td>{{ regsitro.hsalida}}</td>  
                                    <td>{{ regsitro.fecha}}</td>  
                                    <td>{{ regsitro.valorparqueo}}</td>  
                                </tr> 
                            </tbody>
                          </table>
                    </div>
                </div>
                <div class="col-sm-2" >
                    
                        <div class="text-center">
                            <img src="https://i.ibb.co/s6qbdJJ/parking.jpg" style="width: 200px;" class="rounded" alt="...">
                          </div>
                    
                </div>
            </div>
        </div>
    </body>
    <script>
        var app = angular.module('Easyparking',[]);
        app.controller('registrosController',['$http',controladorRegistros]);
        function controladorRegistros($http){
            var cn = this;
            cn.listarRegistro = function () {
                var url = "peticiones.jsp";
                var params = {
                    proceso: "listarRegistro" 
                };
                $http({
                method: 'POST',
                url: 'peticiones.jsp',
                params: params
                }).then(function (res){
                    cn.registros = res.data.registros;
                });
                };
            
            cn.guardarRegistro = function(){
                var registro = {
                    proceso: "guardarRegistro",
                    lugar: cn.lugar,
                    matricula: cn.matricula,
                    vehiculo: cn.tipovehiculo,
                    hentrada: cn.hentrada,
                    hsalida: cn.hsalida,
                    fecha: cn.fecha,
                    Vparqueo: cn.valorparqueo    
                };
                console.log(registro);
                $http({
                    method: 'POST',
                    url: 'peticiones.jsp',
                    params: registro
                }).then(function (res){
                    if(res.data.ok === true){
                        if(res.data[registro.proceso]=== true){
                            alert("Guardado con exito");
                        }else{alert("Error al guardar, verifique los datos");}
                    }else{alert(res.data.errorMsg);}
                });
            };
            cn.elimarRegistro = function(){
                var registro ={
                    proceso:"eliminarRegistro",
                    id: cn.id
                };
                $http({
                    method: 'POST',
                    url: 'peticiones.jsp',
                    params: registro
                }).then(function (res){
                    if(res.data.ok === true){
                        if(res.data[registro.proceso] === true){
                            alert("Elimado con exito");
                        }else{alert("Error al eliminar");}
                    }else{alert(res.data.errorMsg);}
                });
            };
            cn.actualizarRegistro= function(){
                var registro ={
                    proceso: "actualizarRegistro",
                    id:cn.id,
                    lugar: cn.lugar,
                    matricula: cn.matricula,
                    vehiculo: cn.tipovehiculo,
                    hentrada: cn.hentrada,
                    hsalida: cn.hsalida,
                    fecha: cn.fecha,
                    Vparqueo: cn.valorparqueo
                };
                $http({
                    method: 'POST',
                    url: 'peticiones.jsp',
                    params: registro
                }).then(function (res){
                    if(res.data.ok === true){
                        if(res.data[registro.proceso]=== true){
                            alert("ACtulizado con exito");
                        }else{alert("Error al actulizar, verifique los datos");}
                    }else{alert(res.data.errorMsg);}
                });
            };
            
        }
    </script>
</html>
