/**
 * 
 */

class node{
	
	constructor(id,name,x,y)
	{
		this.id=id;
		this.name=name;
		this.x=x;
		this.y=y;
	}
}

class edge{
	
	constructor(source,dest)
	{
		this.source=source;
		this.dest=dest;
		
	}
}


function test(placeJson,pathJson,hotelJson,userJson,agentJson)
{
	
	
	var hotelImage='file:///Users/deena-pt2364/Desktop/tomcat/apache-tomcat-9.0.14/webapps/HotelApp/conf/hotel.jpeg';
	var userImage='file:///Users/deena-pt2364/Desktop/tomcat/apache-tomcat-9.0.14/webapps/HotelApp/conf/user.jpeg';
	var agentImage='file:///Users/deena-pt2364/Desktop/tomcat/apache-tomcat-9.0.14/webapps/HotelApp/conf/agent.jpeg';
	var pl=JSON.parse(placeJson);
	var pa=JSON.parse(pathJson);
	var hotel=JSON.parse(hotelJson);
	var user=JSON.parse(userJson);
	var agent=JSON.parse(agentJson);
	//var path=JSON.parse(orderPath);
	var nodesdata=[];
	var edgesdata=[];
	
	for(var i=0;i<pl.length;i++)
		{
		  nodesdata.push({id:pl[i].locationId,label:pl[i].name,x:pl[i].x,y:pl[i].y});
		}
	for(var i=0;i<pa.length;i++)
	{
	  edgesdata.push({to:pa[i].dest,from:pa[i].source,width:1});
	}
	
	nodesdata.push({shape: 'image', image: hotelImage,label:hotel.name,x:hotel.x,y:hotel.y});
	nodesdata.push({shape: 'image', image: userImage,label:user.name,x:user.x,y:user.y});
	nodesdata.push({shape: 'image', image: agentImage,label:agent.name,x:agent.x,y:agent.y});
	
	/*for(var i=0;i<path.length-1;i++)
		{
		edgesdata.push({to:path[i],from:path[i+1],width:3});
		}*/
	var nodes=new vis.DataSet(nodesdata);
	var edges=new vis.DataSet(edgesdata);
	var red='#f44242';
	/*var nodes = new vis.DataSet([
    {id: 1, label: 'A',x:0,y:0},
    {id: 2, label: 'B',x:100,y:150},
    {id: 3, label: 'C',x:200,y:100},
    {id: 4, label: 'D',x:120,y:300},
    {id:5,shape: 'image', image: hotelImage,label:'saravana',x:20,y:20},
    {id:6,shape: 'image', image: userImage,label:'deena',x:210,y:110},
    {id:7,shape: 'image', image: agentImage,label:'ram',x:60,y:85},
   
  ]);

  // create an array with edges
  var edges = new vis.DataSet([
    
    {from: 1, to: 2, width: 1},
    {from: 2, to: 4, width: 3,color:'red'},
    {from: 4, to: 3, width: 1},
    {from: 3, to: 1, width: 1},
  ]);*/

  
  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  
  var network = new vis.Network(container, data, options);
  var options = {
  	  height: '100%',
       width: '100%',
       physics:{
           stabilization: true,
       },
    nodes: {
      borderWidth: 4,
      size: 10,
      fixed:true,
      physics:false,
      color: {
        border: '#222222',
        background: '#ffffff'
      },
      font:{
        color:red
      }
    },
    edges: {
      color: 'lightgray'
    },
    layout: {randomSeed:0}
  };
network.setOptions(options);
}