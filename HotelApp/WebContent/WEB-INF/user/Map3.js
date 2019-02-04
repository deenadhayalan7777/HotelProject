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
	
	
	var hotelImage='/HotelApp/conf/hotel.jpeg';
	var agentImage='/HotelApp/conf/agent.jpeg';
	var userImage='/HotelApp/conf/user.jpeg';
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
	
	nodesdata.push({shape: 'image', image: hotelImage,label:hotel.name,x:(parseInt(hotel.x)+20),y:(parseInt(hotel.y)+20)});
	nodesdata.push({shape: 'image', image: userImage,label:user.name,x:(parseInt(user.x)+20),y:(parseInt(user.y)+20)});
	nodesdata.push({shape: 'image', image: agentImage,label:'Agent',x:(parseInt(agent.x)),y:(parseInt(agent.y))});
	
	/*for(var i=0;i<path.length-1;i++)
		{
		edgesdata.push({to:path[i],from:path[i+1],width:3});
		}*/
	var nodes=new vis.DataSet(nodesdata);
	var edges=new vis.DataSet(edgesdata);
	var red='#f44242';
	
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