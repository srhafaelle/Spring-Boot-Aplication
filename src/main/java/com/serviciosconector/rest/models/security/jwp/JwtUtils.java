package com.serviciosconector.rest.models.security.jwp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j    //esto es para usar en el boolena  de la validacion de token
public class JwtUtils {
    @Value(("${jwt.secret.key}"))
    private String secrekey;
    @Value(("${jwt.time.expiration}"))
    private String timeExperitaion;

    //generar token de acceso
    public String generateAccesToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExperitaion)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //validarcion de token de acceso
    public boolean isTokenValid(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        }catch (Exception e){

            log.error("token invalid, error ".concat(e.getMessage()));
            return false;
        }
    }
    //obtener username del token
    public String getUsernameFromTokem(String token){
        return  getClaim(token, Claims::getSubject); //obtengo del token el nombre puegdo obtener varias partes del token que necesite
    }
    //obtener un solo claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){

        Claims claims = extracAllClaims(token);
        return claimsTFunction.apply(claims);
    }
    //obtener los clein del token la informacion del token
    public Claims extracAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //Obtener fimar del token
    public Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secrekey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
