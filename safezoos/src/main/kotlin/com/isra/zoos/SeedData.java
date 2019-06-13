package com.isra.zoos;

import com.isra.zoos.model.Role;
import com.isra.zoos.model.User;
import com.isra.zoos.model.UserRoles;
import com.isra.zoos.repository.RoleRepository;
import com.isra.zoos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role adminRole = new Role(Role.ADMIN);
        Role userRole = new Role(Role.USER);
        Role zoodataRole = new Role(Role.ZOODATA);
        Role animaldataRole = new Role(Role.ANIMALDATA);
        Role mgrRole = new Role(Role.MGR);

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), adminRole));
        admins.add(new UserRoles(new User(), userRole));
        admins.add(new UserRoles(new User(), zoodataRole));
        admins.add(new UserRoles(new User(), animaldataRole));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), userRole));

        ArrayList<UserRoles> zoodatas = new ArrayList<>();
        zoodatas.add(new UserRoles(new User(), zoodataRole));

        ArrayList<UserRoles> animaldatas = new ArrayList<>();
        animaldatas.add(new UserRoles(new User(), animaldataRole));

        ArrayList<UserRoles> mgrs = new ArrayList<>();
        mgrs.add(new UserRoles(new User(), mgrRole));

        rolerepos.save(adminRole);
        rolerepos.save(userRole);
        rolerepos.save(zoodataRole);
        rolerepos.save(animaldataRole);
        rolerepos.save(mgrRole);

        User u1 = new User("admin", "password", admins);
        userrepos.save(u1);

        User u2 = new User("animal", "animal", animaldatas);
        userrepos.save(u2);

        User u3 = new User("zoo", "zoo", zoodatas);
        userrepos.save(u3);

        User ur = new User("mgr", "mgr", mgrs);



    }
}
