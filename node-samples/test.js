console.log(process.argv);
var ffi = require('ffi-napi');
var path = require('path');
var lib = ffi.Library(path.join(__dirname, 'libmpc_hd_gg18.so'), {
	    'keygen': [ 'void', ['string','string','string','string']],
	    'sign': ['void', ['string','string','string','string','string','string']],
	    'keygendun': [ 'void', ['string','string','string','string','string','string']],
	    'keygendunnew': [ 'void', ['string','string','string','string','string','string']]
});

function sign(url, keyfile, config, message, code) {
	    lib.sign(url, keyfile, config, message, code, '');
}


function keygendun(url, keyfile, config, code) {
    lib.keygendun(url, keyfile, config, code, '', '');
}

function keygendunnew(url, keyfile, config, code) {
    lib.keygendunnew(url, keyfile, config, code, '', '');
}


var cmd = process.argv[2];
var args = process.argv.slice(3);
if (cmd === 'keygen') {
    lib.keygen(...args);
}
else if (cmd === 'sign') {
    if (process.argv.length - 3 === 5) {
        sign(...args);
    } else {
        lib.sign(...args);
    }
}
else if (cmd === 'keygendunnew') {
    if (process.argv.length - 3 === 4) {
        keygendunnew(...args);
    } else {
        lib.keygendunnew(...args);
    }
}
else if (cmd === 'keygendun') {
    if (process.argv.length - 3 === 4) {
        keygendun(...args);
    } else {
        lib.keygendun(...args);
    }
}
else {
    console.log(`Interface ${cmd} not yet supported.`);
}
