const express = require("express")
const sequelize  = require("./config/db")
const app = express()
const dotenv = require('dotenv');
const morgan =require('morgan');
const colors = require('colors')
require('dotenv').config();

const Eureka = require('eureka-js-client').Eureka;
dotenv.config();

 
app.use(express.json())
app.use(morgan('dev'))



const client = new Eureka({
  instance: {
    app: 'MicroserviceEnCommun',  
    hostName: 'MicroserviceEnCommun',     
    ipAddr: '172.18.0.4',       
    port: {
        '$': 5000,             
        '@enabled': true
    },
    vipAddress: 'MicroserviceEnCommun', 
    dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn'
    }
},
eureka: {
    host: 'eurekaserver',        
    port: 8761,                
    servicePath: '/eureka/apps'
}
});

client.start(error => {
  console.log('Eureka client started');
});


app.use('/users',require('./routes/userRoutes'));
app.use("/auth",require("./routes/authRoutes"))


const port= process.env.PORT || 5000



sequelize
  .authenticate()
  .then(() => {
    console.log('Database connected successfully');

   
    app.listen(port,()=>{
        console.log(`server is running on port ${port} in Mode ${process.env.DEV_MODE} `.bgCyan.white)
    });
  })
  .catch((error) => {
    console.error('Unable to connect to the database:', error);
  });



