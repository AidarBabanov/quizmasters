/**
 * Created by serikzhilibayev on 12.07.17.
 */
var i = 0;
console.log("hello");
$('a').click(function(){
    console.log(i);
    if (i % 2 === 0) {
        $('.rect2').css("display", "none");
        $('.rect').css("display", "block");
        i++;
    }else {
        $('.rect').css("display", "none");
        $('.rect2').css("display", "block");
        i++;
    }
});