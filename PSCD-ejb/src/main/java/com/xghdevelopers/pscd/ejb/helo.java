package com.xghdevelopers.pscd.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.xghdevelopers.pscd.ejb.local.heloLocal;

@Local
@Stateless(mappedName="helo")
public class helo implements heloLocal{

}
