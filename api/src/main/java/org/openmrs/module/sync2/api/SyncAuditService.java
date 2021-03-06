package org.openmrs.module.sync2.api;

import com.google.gson.JsonParseException;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.sync2.SyncModuleConfig;
import org.openmrs.module.sync2.api.model.audit.AuditMessage;

import org.springframework.transaction.annotation.Transactional;

public interface SyncAuditService extends OpenmrsService {

    @Authorized(SyncModuleConfig.SYNC_AUDIT_PRIVILEGE)
    @Transactional(readOnly = true)
    AuditMessage getMessageById(Integer id) throws APIException;

    @Authorized(SyncModuleConfig.SYNC_AUDIT_PRIVILEGE)
    @Transactional(readOnly = true)
    String getJsonMessageById(Integer id) throws APIException, JsonParseException;

    @Authorized(SyncModuleConfig.SYNC_AUDIT_PRIVILEGE)
    @Transactional(readOnly = true)
    String getPaginatedMessages(Integer page, Integer pageSize) throws APIException;

    @Authorized(SyncModuleConfig.SYNC_AUDIT_PRIVILEGE)
    AuditMessage saveItem(AuditMessage auditMessage) throws APIException;
}