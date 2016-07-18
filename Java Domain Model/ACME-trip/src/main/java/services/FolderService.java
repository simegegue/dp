package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Folder;
import domain.Message;
import domain.User;

import repositories.FolderRepository;

@Service
@Transactional
public class FolderService {
	
	// Managed Repository----------------------------------------------------
			@Autowired
			private FolderRepository folderRepository;
			
	// Supporting Services---------------------------------------------------
	// Constructors----------------------------------------------------------
			public FolderService(){
				super();
			}
			
	// Simple CRUD Methods---------------------------------------------------
			public Folder findOne(int folderId){
				Assert.isTrue(folderId != 0);
				Folder result;
				result = folderRepository.findOne(folderId);
				Assert.notNull(result);
				return result;
			}
			
			public void save(Folder folder){
				Assert.notNull(folder);
				folderRepository.saveAndFlush(folder);
			}
			
			public void edit(Folder folder){
				Assert.notNull(folder);
				folderRepository.saveAndFlush(folder);
			}
			
			public void delete(int folderId){
				Assert.isTrue(folderId != 0);
				Folder folder = findOne(folderId);
				Assert.isTrue(!folder.getName().equals("InFolder")||
						!folder.getName().equals("OutFolder")||!folder.getName().equals("TrashFolder")
						||!folder.getName().equals("StarredFolder")||!folder.getName().equals("SpamFolder"));
				folderRepository.delete(folderId);
			}
			
			public Folder create(){
				Folder result = new Folder();
				return result;
			}
			
			public Collection<Folder> createFolders(User result){
				Collection<Folder> folders = new ArrayList<>();
				
				Folder folder1 = create();
				folder1.setName("IntFolder");
				folder1.setDescription("Carpeta de entrada");
				folder1.setUser(result);
				Folder folder2 = create();
				folder2.setName("OuttFolder");
				folder2.setDescription("Carpeta de salida");
				folder2.setUser(result);
				Folder folder3 = create();
				folder3.setName("TrashtFolder");
				folder3.setDescription("Papelera");
				folder3.setUser(result);
				Folder folder4 = create();
				folder4.setName("StarredtFolder");
				folder4.setDescription("Carpeta de favoritos");
				folder4.setUser(result);
				
				Folder folder5 = create();
				folder5.setName("SpamtFolder");
				folder5.setDescription("Carpeta de spam");
				folder5.setUser(result);
				
				folders.add(folder1);
				folders.add(folder2);
				folders.add(folder3);
				folders.add(folder4);
				folders.add(folder5);
				
				return folders;
			}
// Metodos para encontrar las carpetas de cada user			
			public Folder inFolder(User user){
				Folder result = null;
				for(Folder aux:user.getFolders()){
					if(aux.getName().equals("InFolder")){
						result = aux;
					}
				}
				return result;
			}
			
			public Folder outFolder(User user){
				Folder result = null;
				for(Folder aux:user.getFolders()){
					if(aux.getName().equals("OutFolder")){
						result = aux;
					}
				}
				return result;
			}
			
			public Folder spamFolder(User user){
				Folder result = null;
				for(Folder aux:user.getFolders()){
					if(aux.getName().equals("SpamFolder")){
						result = aux;
					}
				}
				return result;
			}
			
			public Folder starredFolder(User user){
				Folder result = null;
				for(Folder aux:user.getFolders()){
					if(aux.getName().equals("StarredFolder")){
						result = aux;
					}
				}
				return result;
			}
			
			public Folder trashFolder(User user){
				Folder result = null;
				for(Folder aux:user.getFolders()){
					if(aux.getName().equals("TrashFolder")){
						result = aux;
					}
				}
				return result;
			}

}
