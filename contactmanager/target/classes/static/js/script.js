const toggle =()=>{

    if ($(".sidebar").is(":visible")) {
        
        $(".sidebar").css("display" , "none");
        $(".content").css("margin-left" , "2%");
    } else {
        $(".sidebar").css("display" , "block");
        $(".content").css("margin-left" , "20%");
    }

};


const search =()=>{

    let keywords = $("#search-input").val();
    console.log(keywords)

    if (keywords == "") {
        $(".search-result").hide();
    }
    else{
        let url = `http://localhost:8282/search/${keywords}`

        fetch(url).then((response) =>
        {
            return response.json()
        }
    ).then((data) =>{
        console.log(data)
        let text = ``
        data.forEach(contact => {
            text+=`<a href = '/user/profile/${contact.cId}' class = 'list-group-item list-group-action' > ${contact.name} </a>`
        });

        $(".list-group").html(text);
    })
        $(".search-result").show();
    }
}


