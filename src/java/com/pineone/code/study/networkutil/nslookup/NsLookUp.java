package com.pineone.code.study.networkutil.nslookup;

import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by pahnj on 2015-12-06.
 * nslookup 명령어 구현
 * 리눅스 명령어 중, domain name으로 IP를 조회하는 nslookup이 있는데 해당 메소드 구현
 */
@Service
public class NsLookUp implements INsLookUp {


    public String hostToAddress(String hostname) {
        try {
            ArrayList<String> result = new ArrayList<String>();

            InetAddress[] hosts = InetAddress.getAllByName(hostname);


            if (hosts.length < 1) return null;


            for (int i = 0; i < hosts.length; i++) {
                result.add(hosts[i].getHostAddress());
            }

            return result.toString();
        } catch (UnknownHostException ex) {
            return null;
        }

    }


    @Override
    public String getAddress(String host) {
        return hostToAddress(host);
    }
}
