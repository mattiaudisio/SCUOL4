#!/bin/bash

function esci {
    exit
}

function somma {
    local a=$1
    b=$2
    ((som=$a+$b))
    return $som
}

somma 6 3
echo $?
echo $a
esci

